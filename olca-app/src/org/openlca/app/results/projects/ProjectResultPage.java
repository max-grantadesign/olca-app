package org.openlca.app.results.projects;

import java.util.Set;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.openlca.app.M;
import org.openlca.app.components.ResultTypeSelection;
import org.openlca.app.components.ResultTypeSelection.EventHandler;
import org.openlca.app.db.Cache;
import org.openlca.app.util.CostResultDescriptor;
import org.openlca.app.util.Labels;
import org.openlca.app.util.Numbers;
import org.openlca.app.util.UI;
import org.openlca.app.util.tables.Tables;
import org.openlca.core.database.EntityCache;
import org.openlca.core.model.ProjectVariant;
import org.openlca.core.model.descriptors.FlowDescriptor;
import org.openlca.core.model.descriptors.ImpactCategoryDescriptor;
import org.openlca.core.results.ContributionItem;
import org.openlca.core.results.ContributionSet;
import org.openlca.core.results.ProjectResultProvider;

public class ProjectResultPage extends FormPage {

	private EntityCache cache = Cache.getEntityCache();
	private ProjectResultProvider result;
	private ProjectResultChart chart;
	private ResultTypeSelection selector;
	private TableViewer tableViewer;

	public ProjectResultPage(ProjectResultEditor editor) {
		super(editor, "ProjectResultPage", M.ProjectResults);
		this.result = editor.getResult();
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = UI.formHeader(managedForm, M.ProjectResults);
		FormToolkit toolkit = managedForm.getToolkit();
		Composite body = UI.formBody(form, toolkit);
		Composite composite = toolkit.createComposite(body);
		UI.gridLayout(composite, 2);
		selector = ResultTypeSelection.on(result, cache)
				.withEventHandler(new SelectionHandler())
				.create(composite, toolkit);
		createTable(body, toolkit);
		createChart(body);
		toolkit.adapt(chart);
		initialSelection(selector);
		form.reflow(true);
	}

	private void createTable(Composite body, FormToolkit toolkit) {
		Composite composite = UI.formSection(body, toolkit, M.Results);
		UI.gridLayout(composite, 1);
		tableViewer = Tables.createViewer(composite,
				new String[] { M.Variant, M.Amount, M.Unit });
		tableViewer.setLabelProvider(new TableLabel());
		Tables.bindColumnWidths(tableViewer, 0.4, 0.3, 0.3);
	}

	private void initialSelection(ResultTypeSelection selector) {
		Set<FlowDescriptor> flowSet = result.getFlowDescriptors();
		if (flowSet.isEmpty())
			return;
		FlowDescriptor flow = flowSet.iterator().next();
		selector.selectWithEvent(flow);
	}

	private void createChart(Composite body) {
		chart = new ProjectResultChart(body);
		GridData gridData = UI.gridData(chart, false, false);
		gridData.horizontalAlignment = SWT.CENTER;
		gridData.heightHint = 350;
		gridData.widthHint = 550;
	}

	private class SelectionHandler implements EventHandler {
		@Override
		public void flowSelected(FlowDescriptor flow) {
			ContributionSet<ProjectVariant> contributionSet = result
					.getContributions(flow);
			chart.renderChart(flow, contributionSet);
			tableViewer.setInput(contributionSet.contributions);
		}

		@Override
		public void impactCategorySelected(
				ImpactCategoryDescriptor impactCategory) {
			ContributionSet<ProjectVariant> contributionSet = result
					.getContributions(impactCategory);
			chart.renderChart(impactCategory, contributionSet);
			tableViewer.setInput(contributionSet.contributions);
		}

		@Override
		public void costResultSelected(CostResultDescriptor cost) {
		}
	}

	private class TableLabel extends LabelProvider implements
			ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		@SuppressWarnings("unchecked")
		public String getColumnText(Object element, int col) {
			if (!(element instanceof ContributionItem))
				return null;
			ContributionItem<ProjectVariant> contribution = (ContributionItem<ProjectVariant>) element;
			switch (col) {
			case 0:
				return contribution.item.getName();
			case 1:
				return Numbers.format(contribution.amount);
			case 2:
				return getUnit();
			default:
				return null;
			}
		}

		private String getUnit() {
			Object selection = selector.getSelection();
			if (selection instanceof FlowDescriptor)
				return Labels.getRefUnit((FlowDescriptor) selection,
						Cache.getEntityCache());
			if (selection instanceof ImpactCategoryDescriptor)
				return ((ImpactCategoryDescriptor) selection)
						.getReferenceUnit();
			return null;
		}

	}

}
