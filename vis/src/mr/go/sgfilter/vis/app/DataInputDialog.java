/*
 * Copyright [2009] [Marcin Rzeźnicki]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package mr.go.sgfilter.vis.app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;

public class DataInputDialog extends javax.swing.JDialog {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton		cancelButton;

	private JButton		okButton;

	private JTextArea	text;

	/** Creates new form DataInputDialog */
	public DataInputDialog(
			java.awt.Frame parent) {
		super(parent);
		initComponents();
	}

	// End of variables declaration//GEN-END:variables

	public double[] openDialog() throws InputMismatchException {
		setVisible(true);
		String text = this.text.getText();
		if (text == null || text.isEmpty()) {
			return null;
		}
		final Scanner scanner = new Scanner(text);
		scanner.useLocale(Locale.ROOT);
		scanner.useDelimiter("\\s*(;\\s*|\\r\\n|\\n)");
		List<Double> numbers = new LinkedList<Double>();
		while (scanner.hasNext()) {
			numbers.add(scanner.nextDouble());
		}
		final Double[] tmp = new Double[numbers.size()];
		numbers.toArray(tmp);
		double[] result = new double[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			result[i] = tmp[i];
		}
		return result;
	}

	private void cancelButtonActionPerformed(ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
		text.setText(null);
		dispose();
	}// GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		JScrollPane jScrollPane1 = new JScrollPane();
		text = new JTextArea();
		okButton = new JButton();
		cancelButton = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ResourceMap resourceMap = Application
				.getInstance(mr.go.sgfilter.vis.app.Application.class)
				.getContext()
				.getResourceMap(DataInputDialog.class);
		setTitle(resourceMap.getString("DataInputDialog.title")); // NOI18N
		setAlwaysOnTop(true);
		setModal(true);
		setName("DataInputDialog"); // NOI18N
		setResizable(false);

		jScrollPane1.setName("jScrollPane1"); // NOI18N

		text.setColumns(20);
		text.setLineWrap(true);
		text.setRows(5);
		text.setToolTipText(resourceMap.getString("text.toolTipText")); // NOI18N
		text.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		text.setName("text"); // NOI18N
		jScrollPane1.setViewportView(text);

		okButton.setText(resourceMap.getString("okButton.text")); // NOI18N
		okButton.setName("okButton"); // NOI18N
		okButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
		cancelButton.setName("cancelButton"); // NOI18N
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																Alignment.CENTER)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				okButton)
																		.addGap(
																				5,
																				5,
																				5)
																		.addComponent(
																				cancelButton))
														.addComponent(
																jScrollPane1,
																GroupLayout.DEFAULT_SIZE,
																380,
																Short.MAX_VALUE))
										.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						Alignment.TRAILING,
						layout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(
										jScrollPane1,
										GroupLayout.DEFAULT_SIZE,
										249,
										Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										layout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(okButton)
												.addComponent(cancelButton))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void okButtonActionPerformed(ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		dispose();
	}// GEN-LAST:event_okButtonActionPerformed

	private static final long	serialVersionUID	= -2610740366431362553L;
}