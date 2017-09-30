/**
 * Defines the progress bar for the search
 */
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 * Defines the progress of the search.
 */
public class Progress {

	/** The ProgressBar. */
	final JProgressBar pb = SearchPNL.userInput;

	/**
	 * Progress.
	 */
	public void progress() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				progressWorker worker = new progressWorker();
				worker.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
							pb.setValue(worker.getProgress());
						}
					}
				});
				pb.setStringPainted(true);
				worker.execute();
			}
		});
	}

	/**
	 * Reads the file 
	 */
	class progressWorker extends SwingWorker<List<String>, String> {

		/** The total bytes. */
		long totalBytes = 0;

		/* (non-Javadoc)
		 * @see javax.swing.SwingWorker#doInBackground()
		 */
		@Override
		protected List<String> doInBackground() throws Exception {
			List<String> lines = new ArrayList<>();
			File textFile = new File("src/city.json");
			long byteLength = textFile.length();

			try (InputStream is = new FileInputStream(textFile)) {

				byte[] content = new byte[1024];
				int bytesRead = -1;

				String lastText = "";
				while ((bytesRead = is.read(content)) != -1) {
					totalBytes += bytesRead;
					setProgress(Math.round(((float) totalBytes / (float) byteLength) * 100f));

					String text = lastText + new String(content);
					boolean keepEnd = !text.endsWith("\n");
					String[] parts = text.split("\n");

					for (int count = 0; count < (keepEnd ? parts.length - 1 : parts.length); count++) {
						lines.add(parts[count]);
						publish(parts[count]);
					}
					if (keepEnd) {
						lastText = parts[parts.length - 1];

					} else {
						lastText = "";
					}
				}
			}
			MainClass.cardLayout.show(MainClass.cardPanel, "1");
			SearchPNL.userInput.setStringPainted(false);
			MainClass.btn1.setVisible(true);
			MainClass.btn2.setVisible(true);

			return lines;
		}
	}
}
