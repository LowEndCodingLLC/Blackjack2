
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	GameWindow window=new GameWindow();
	window.getTable().getPlayer().hit();	
	window.getTable().getPlayer().hit();
	//window.getTable().getPlayer().print();
	
	Hand test = new Hand(window.getTable());
	test.add(new Card(1,"heart",null));
	test.add(new Card(2,"heart",null));
	test.add(new Card(13,"heart",null));
	System.out.println(test.getValue());
		
		
	}

}
