package org.openlca.app.cloud.navigation.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.openlca.app.cloud.index.DiffIndexer;
import org.openlca.app.cloud.index.DiffType;
import org.openlca.app.cloud.navigation.NavigationRoot;
import org.openlca.app.cloud.navigation.NavigationUtil;
import org.openlca.app.cloud.navigation.RepositoryElement;
import org.openlca.app.cloud.navigation.RepositoryNavigator;
import org.openlca.app.db.Database;
import org.openlca.app.navigation.CategoryElement;
import org.openlca.app.navigation.INavigationElement;
import org.openlca.app.navigation.ModelElement;
import org.openlca.app.navigation.actions.INavigationAction;
import org.openlca.app.util.Info;
import org.openlca.app.util.UI;

import com.greendelta.cloud.api.RepositoryClient;
import com.greendelta.cloud.api.RepositoryConfig;
import com.greendelta.cloud.model.data.DatasetDescriptor;
import com.greendelta.cloud.util.WebRequests.WebRequestException;

public class ConnectAction extends Action implements INavigationAction {

	@Override
	public String getText() {
		return "#Connect to repository...";
	}

	@Override
	public void run() {
		InputDialog dialog = new InputDialog();
		if (dialog.open() != Dialog.OK)
			return;
		RepositoryConfig config = dialog.createConfig();
		RepositoryClient client = new RepositoryClient(config);
		try {
			// only fetch to check if can connect
			client.requestFetch();
		} catch (WebRequestException e) {
			// TODO handle errors
			Info.showBox(e.getMessage());
			config.disconnect();
			return;
		}
		NavigationRoot root = RepositoryNavigator.getNavigationRoot();
		root.update();
		DiffIndexer indexer = new DiffIndexer(
				RepositoryNavigator.getDiffIndex());
		indexer.addToIndex(collectDescriptors(root.getChildren().get(0)),
				DiffType.NEW);
		RepositoryNavigator.refresh();
	}

	private List<DatasetDescriptor> collectDescriptors(
			INavigationElement<?> element) {
		List<DatasetDescriptor> descriptor = new ArrayList<>();
		if (element instanceof ModelElement
				|| element instanceof CategoryElement)
			descriptor.add(NavigationUtil.toDescriptor(element));
		for (INavigationElement<?> child : element.getChildren())
			descriptor.addAll(collectDescriptors(child));
		return descriptor;
	}

	private class InputDialog extends Dialog {

		private String serverUrl;
		private String username;
		private String password;
		private String repositoryId;

		protected InputDialog() {
			super(UI.shell());
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite container = UI.formComposite(parent);
			Text serverText = UI.formText(container, "#Server url");
			serverText.addModifyListener((event) -> {
				serverUrl = serverText.getText();
			});
			Text usernameText = UI.formText(container, "#Username");
			usernameText.addModifyListener((event) -> {
				username = usernameText.getText();
			});
			Text passwordText = UI.formText(container, "#Password",
					SWT.PASSWORD);
			passwordText.addModifyListener((event) -> {
				password = passwordText.getText();
			});
			Text repoText = UI.formText(container, "#Repository id");
			repoText.addModifyListener((event) -> {
				repositoryId = repoText.getText();
			});
			// TODO remove dummy input
			serverText.setText("http://46.105.145.95:8080/lca-cloud-ws");
			usernameText.setText("greve");
			passwordText.setText("12345sechs");
			repoText.setText("greve/" + Database.get().getName());
			//
			return container;
		}

		private RepositoryConfig createConfig() {
			return RepositoryConfig.connect(Database.get(), serverUrl + "/ws",
					repositoryId, username, password);
		}
	}

	@Override
	public boolean accept(INavigationElement<?> element) {
		if (!(element instanceof RepositoryElement))
			return false;
		RepositoryConfig config = ((RepositoryElement) element).getContent();
		if (config != null)
			return false;
		return true;
	}

	@Override
	public boolean accept(List<INavigationElement<?>> elements) {
		return false;
	}

}
