package taxi;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;


public class Form extends JFrame {
	private JLabel name = new JLabel ("  Имя: ");
	private JLabel fromadr = new JLabel ("  Пункт отправления: ");
	private JLabel toadr = new JLabel ("  Пункт назначения: ");
	private JLabel way = new JLabel ("  Длина пути (км): ");
	
	
	
	private JTextField name1= new JTextField("");
	private final String[] fromadr1 = { "ул. Герасименко" ,"ул. Евдокимова"  ,"ул. Турмалиновская","пл. Ленина"};
	private final String[] toadr1 =   { "ул. Космонавтов" ,"ул. Волкова"  ,"ул. Капустина","ул. Орбитальная"};
	private final String[][] adresses =   { {"ул. Космонавтов","102"} ,{"ул. Волкова","212"}  ,{"ул. Капустина","93"},{"ул. Орбитальная","76"},
	{ "ул. Герасименко","140" },{"ул. Евдокимова" ,"175" },{"ул. Турмалиновская","139"},{"пл. Ленина","150"}};
	
	JComboBox<String> fromlist = new JComboBox<String>(fromadr1);
	JComboBox<String> tolist = new JComboBox<String>(toadr1);
	private JTextField way1= new JTextField("0");
	public JCheckBox chbx = new JCheckBox("<html>Поездка с другим клиентом</html>");
	private JButton itog = new JButton("Рассчитать");
	
	
	public Form() {
	
	
	super ("Такси");
	this.setBounds(715,300,350,300);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container container = this.getContentPane();
	container.setLayout(new GridLayout(5,2,3,3));
	container.add(name);
	container.add(name1);
	container.add(fromadr);
	container.add(fromlist);
	container.add(toadr);
	container.add(tolist);
	container.add(way);
	container.add(way1);
	container.add(chbx);
	container.add(itog);
	
	
	 way1.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = way1.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() ==  KeyEvent.VK_BACK_SPACE) {
               way1.setEditable(true);
              // way1.setText("");
            } else {
               way1.setEditable(false);
               
             
            }
         }
      });
	 
	 	 
	 itog.addActionListener(new counttss());
	}
	
	
	
	
	public String n_ame="";
	
	
	class counttss implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String message="";
			int sum = 0;
			

			if(name1.getText().equals("")) message="Вы не ввели имя";
			else {
				for(int i = 0; i < adresses.length; i++) {
				if ((String) fromlist.getSelectedItem() == adresses[i][0])
				sum += Integer.parseInt(adresses[i][1]);
				if ((String) tolist.getSelectedItem() == adresses[i][0]) 
				sum += Integer.parseInt(adresses[i][1]);
				sum +=( Integer.parseInt(way1.getText()))*1;}
			message+="Добрый день, "+name1.getText();
			n_ame=name1.getText();
			getName(n_ame);
			message+="\nАдрес отправления: "+fromlist.getSelectedItem();
			message+="\nКонечный адрес: "+tolist.getSelectedItem();
			message+="\nДлина пути: "+way1.getText()+" км";
			if(chbx.isSelected()) {
				message+="\nПоездка: Совместная";
				sum=(int)(sum-Double.valueOf(sum)*0.1);
			}
			else message+="\nПоездка: Одиночная";
			message+="\nСтоимость поездки: "+sum+" руб.";
			JOptionPane.showMessageDialog(null,message,"Результат", JOptionPane.PLAIN_MESSAGE);
		}
	}
		

	}
	
	
	public static boolean getName(String name) {
		
		if (name.isEmpty() ==false) {
			
		return true;
		}
		else {
			return false;
		}
		
		}

	

	
	public static boolean getKm(String km) {
		
		if (km.isEmpty() ==false) {
			
		return true;
		}
		else {
			return false;
		}
		
		}

	

	
	
	
	

}
	
	

	

	
	
