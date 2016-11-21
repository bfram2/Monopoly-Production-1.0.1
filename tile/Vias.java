package tile;
//import pieces.*;


	public class Vias{

		public int tileNumber;
		private String name;
		private String imageName;
		private int group;
		private int cost;
		private int mortgage;
		private int owner;
		private int singleRent;
		private int doubleRent;
		private int tripleRent;
		private int quadRent;
		
		public Vias(int tn,String n,String in, int g, int c, int m, int o,int sr,int dr,int tr,int qr){
			//tileNumber is the number of the property in order starting with Go as 0
			//name is the name of the property
			//group is the color grouping which have been assigned numbers 1-10
			//cost is the initial purchase price
			//mortgage is the amount a player can have added to their bank by mortgaging the property
			//owner is the player that owns the property with 0 as the default no owner/bank owned
			
			this.tileNumber = tn;
			this.name = n;
			this.imageName = in;
			this.group = g;
			this.cost = c;
			this.mortgage = m;
			this.owner = o;
			this.singleRent = sr;
			this.doubleRent = dr;
			this.tripleRent = tr;
			this.quadRent = qr;
		}
		public int getTile(){
			return this.tileNumber;
		}
		public String getName(){
			return this.name;
		}
		public String getImageName(){
			return this.imageName;
		}
		public int getGroup(){
			return this.group;
		}
		public int getCost(){
			return this.cost;
		}
		public int getMortgage(){
			return this.mortgage;
		}
		public int getOwner(){
			return this.owner;
		}
		public int setOwner(){
			return this.owner;
			//this will have to be changed to update the owner
		}
		public int getSingleRent(){
			return this.singleRent;
		}
		public int getDoubleRent(){
			return this.doubleRent;
		}
		public int getTripleRent(){
			return this.tripleRent;
		}
		public int getQuadRent(){
			return this.quadRent;
		}
}
