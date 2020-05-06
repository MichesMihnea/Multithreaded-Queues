import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimView extends JFrame{
	
	private JTextArea s_simField = new JTextArea(10, 40);
	private JTextField s_arrMinField = new JTextField(5);
	private JTextField s_arrMaxField = new JTextField(5);
	private JTextField s_servMinField = new JTextField(5);
	private JTextField s_servMaxField = new JTextField(5);
	private JTextField s_noQueuesField = new JTextField(5);
	private JTextField s_simIntervalField = new JTextField(5);
	private JTextField s_simStep = new JTextField(5);
	private JTextField s_timeStepField = new JTextField(5);
	public JButton s_goButton = new JButton("Go");
	
	public SimView (){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout(FlowLayout.LEFT));
		content.add(new JLabel("Minimum arrival time  "));
		content.add(s_arrMinField);
		content.add(new JLabel("        "));
		content.add(new JLabel("Maximum arrival time  "));
		content.add(s_arrMaxField);
		content.add(new JLabel("Minimum service time"));
		content.add(s_servMinField);
		content.add(new JLabel("        "));
		content.add(new JLabel("Maximum service time"));
		content.add(s_servMaxField);
		content.add(new JLabel("Number of queues       "));
		content.add(s_noQueuesField);
		content.add(new JLabel("        "));
		content.add(new JLabel("Simulation interval        "));
		content.add(s_simIntervalField);
		content.add(new JLabel("                     "));
		content.add(new JLabel("Time step"));
		content.add(s_timeStepField);
		content.add(s_simField);
		content.add(new JLabel("Simulation Step"));
		content.add(s_simStep);
		content.add(new JLabel("                                                                                                           "));
		content.add(new JLabel("                                                              "));
		content.add(s_goButton);
		this.setContentPane(content);
		this.setSize(500, 380);
		this.setTitle("Polynomial Processing");
		this.setVisible(true);
	}
	
	public void addGoListener(ActionListener pGo) {
		s_goButton.addActionListener(pGo);
	}
	
	public void setTextArea(String s) {
		s_simField.setText(s);
	}
	
	public void setSimStep(int simStep) {
		s_simStep.setText(Integer.toString(simStep));
	}
	
	public int getArrMin() {
		return Integer.parseInt(s_arrMinField.getText());
	}
	
	public int getArrMax() {
		return Integer.parseInt(s_arrMaxField.getText());
	}
	
	public int getServMin() {
		return Integer.parseInt(s_servMinField.getText());
	}
	
	public int getServMax() {
		return Integer.parseInt(s_servMaxField.getText());
	}
	
	public int getNoQueues() {
		return Integer.parseInt(s_noQueuesField.getText());
	}
	
	public int getSimInterval() {
		return Integer.parseInt(s_simIntervalField.getText());
	}
	
	public int getTimeStep() {
		return Integer.parseInt(s_timeStepField.getText());
	}
}