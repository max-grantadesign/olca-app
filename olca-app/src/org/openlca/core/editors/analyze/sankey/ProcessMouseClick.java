package org.openlca.core.editors.analyze.sankey;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.openlca.core.application.App;
import org.openlca.core.database.IDatabase;
import org.openlca.core.model.modelprovider.IModelComponent;

/**
 * Opens the process editor on a double click. As 'mouseDoubleClick' not works
 * this listener reacts on 'mousePressed' with a delay function between the
 * clicks.
 */
class ProcessMouseClick implements MouseListener {

	private boolean firstClick = true;
	private ProcessNode processNode;

	public ProcessMouseClick(ProcessNode processNode) {
		this.processNode = processNode;
	}

	@Override
	public void mouseDoubleClicked(MouseEvent evt) {
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		if (evt.button != 1)
			return;
		if (firstClick) {
			firstClick = false;
			scheduleTimer();
		} else {
			IDatabase db = ((ProductSystemNode) processNode.getParent())
					.getEditor().getDatabase();
			IModelComponent process = processNode.getProcess();
			App.openEditor(process, db);
		}
	}

	private void scheduleTimer() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				firstClick = true;
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 250);
	}

	@Override
	public void mouseReleased(MouseEvent evt) {
	}

}