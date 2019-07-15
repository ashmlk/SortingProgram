/**
 * @author Arshia Malekahmadi
 */
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*; 

@SuppressWarnings("serial")
public class SortingFrame extends JFrame{
	
	final static int FRAME_WIDTH = 800;
	final static int FRAME_LENGTH = 200;
	final static int ROUNDS = 88888;
	
	private JButton b0 = new JButton("Quick Sort");
	private JButton b1 = new JButton("Bubble Sort");
	private JButton b2 = new JButton("Insertion Sort");
	private JButton b3 = new JButton("Merge Sort");
	private JButton b4 = new JButton("Selection Sort");
	private JButton b5 = new JButton("Heap Sort");
	private JButton br = new JButton("Read File");
	private JButton bw = new JButton("Generate File");
	private JTextField timeField = new JTextField(14);
	private JTextField statusField = new JTextField("File not generated",24);
	private JLabel time = new JLabel("Running time: ", JLabel.CENTER);
	private JLabel timeUnit = new JLabel("Nanoseconds", JLabel.CENTER);
	private JLabel status = new JLabel("File Status: ", JLabel.CENTER);
	private ArrayList<Double> list;
	private double[] arr;
	private QuickSort Ob0;
	private BubbleSort Ob1;
	private InsertionSort Ob2;
	private MergeSort Ob3;
	private SelectionSort Ob4;
	private HeapSort Ob5;
	private long duration;
	
	public SortingFrame() {
		timeField.setEditable(false);
		start();
		setSize(FRAME_WIDTH, FRAME_LENGTH);
	}
	
	public void start() {
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setLayout(new GridLayout(1,6,5,5));

		b0.setPreferredSize(new Dimension(130,50));
		b1.setPreferredSize(new Dimension(130,50));
		b2.setPreferredSize(new Dimension(130,50));
		b3.setPreferredSize(new Dimension(130,50));
		b4.setPreferredSize(new Dimension(130,50));
		b5.setPreferredSize(new Dimension(130,50));
		bw.setPreferredSize(new Dimension(130,50));
		br.setPreferredSize(new Dimension(130,50));
		
		panel3.add(status);
		panel3.add(statusField);
		
		panel2.add(bw);
		panel2.add(br);
		panel2.add(time);
		panel2.add(timeField);
		panel2.add(timeUnit);
		
		panel1.add(b0);
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		panel1.add(b4);
		panel1.add(b5);
		
		getContentPane().add(BorderLayout.CENTER,panel3);
		getContentPane().add(BorderLayout.SOUTH,panel2);
		getContentPane().add(BorderLayout.NORTH,panel1);
		
		b0.addActionListener(new QuickSortActionListener());
		b1.addActionListener(new BubbleSortActionListener());
		b2.addActionListener(new InsertionSortActionListener());
		b3.addActionListener(new MergeSortActionListener());
		b4.addActionListener(new SelectionSortActionListener());
		b5.addActionListener(new HeapSortActionListener());
		bw.addActionListener(new FileWriterActionListener());
		br.addActionListener(new FileReaderActionListener());
		
	}
	class FileWriterActionListener implements ActionListener{
		File file = new File("file.txt");
		FileWriter fw = null;
		Random rand = new Random();
		double num,count = 0;
		public void actionPerformed(ActionEvent event) {
			try {
				fw = new FileWriter(file);
				BufferedWriter w = new BufferedWriter(fw);
				while(count<=ROUNDS) {
				num = rand.nextDouble()*1000;
				w.write(String.valueOf(num));
				w.newLine();
				count++;
			 }
				w.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			statusField.setText("File generated");
		}
	}
	class FileReaderActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			list = new ArrayList<Double>();
			Scanner scan;
			File file = new File("file.txt");
			try {
				scan = new Scanner(file);
				while(scan.hasNextDouble()) {
				list.add(scan.nextDouble());
			}
			scan.close();
			arr = new double[list.size()];
			for(int i = 0; i < arr.length;i++) {
				arr[i] = list.get(i);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
			statusField.setText("File Read");
	  }
	}
	class QuickSortActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
			Ob0 = new QuickSort();
			long start = System.nanoTime();
			Ob0.sort(arr, 0, arr.length-1);
			long end = System.nanoTime();
			duration = TimeUnit.NANOSECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			timeField.setText(String.valueOf(duration));
			statusField.setText("File sorted using Quick Sort");
		}catch(Exception e) {
			statusField.setText("FILE NOT READ");
		}
		}
	}
	class BubbleSortActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
			Ob1 = new BubbleSort();
			long start = System.nanoTime();
			Ob1.sort(arr, arr.length);
			long end = System.nanoTime();
			duration = TimeUnit.NANOSECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			timeField.setText(String.valueOf(duration));
			statusField.setText("File sorted using Bubble Sort");
		}catch(Exception e) {
			statusField.setText("FILE NOT READ");
		}
		}
	}
	class InsertionSortActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
			Ob2 = new InsertionSort();
			long start = System.nanoTime();
			Ob2.sort(arr);
			long end = System.nanoTime();
			duration = TimeUnit.NANOSECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			timeField.setText(String.valueOf(duration));
			statusField.setText("File sorted using Insertion Sort");
		}catch(Exception e) {
			statusField.setText("FILE NOT READ");
		}
		}
	}
	class MergeSortActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
			Ob3 = new MergeSort();
			long start = System.nanoTime();
			Ob3.sort(arr, 0, arr.length-1);
			long end = System.nanoTime();
			duration = TimeUnit.NANOSECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			timeField.setText(String.valueOf(duration));
			statusField.setText("File sorted using Merge Sort");
		}catch(Exception e) {
			statusField.setText("FILE NOT READ");
		}
		}
	}
	class SelectionSortActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
			Ob4 = new SelectionSort();
			long start = System.nanoTime();
			Ob4.sort(arr, arr.length);
			long end = System.nanoTime();
			duration = TimeUnit.NANOSECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			timeField.setText(String.valueOf(duration));
			statusField.setText("File sorted using Selection Sort");
		}catch(Exception e) {
			statusField.setText("FILE NOT READ");
		}
		}
	}
	class HeapSortActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
			Ob5 = new HeapSort();
			long start = System.nanoTime();
			Ob5.sort(arr, arr.length);
			long end = System.nanoTime();
			duration = TimeUnit.NANOSECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			timeField.setText(String.valueOf(duration));
			statusField.setText("File sorted using Heap Sort");
		}catch(Exception e) {
			statusField.setText("FILE NOT READ");
		}
		}
	}
	
}
