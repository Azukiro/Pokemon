package model.pokemon.pokemons;

import java.io.Serializable;
import java.util.Random;

public class StatistiquePokemon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int dmg;
	private final int def;
	private final int dmgspe;
	private final int defspe;
	private final int xpLevel;
	private int pv;
	private final int pvMax;
	
	/**
	 * 
	 * @return random Statistique for a pokemon
	 */
	public static StatistiquePokemon RandomStat() {
		Random rand=new Random();
		return new StatistiquePokemon(5+rand.nextInt(185),  5+rand.nextInt(245), 10+rand.nextInt(184), 20+rand.nextInt(230), 5+rand.nextInt(175), 25+rand.nextInt(200));
	}
	
	public StatistiquePokemon(int dmg, int def, int dmgspe, int defspe, int xpLevel, int pv) {
		this.dmg = dmg;
		this.def = def;
		this.dmgspe = dmgspe;
		this.defspe = defspe;
		this.xpLevel = xpLevel;
		this.pv = pv;
		pvMax=pv;
	}

	@Override
	public String toString() {
		return "StatistiquePokemon [dmg=" + dmg + ", def=" + def + ", dmgspe=" + dmgspe + ", defspe=" + defspe
				+ ", xpLevel=" + xpLevel + ", pv=" + pv + ", pvMax="+pvMax+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + def;
		result = prime * result + defspe;
		result = prime * result + dmg;
		result = prime * result + dmgspe;
		result = prime * result + pv;
		result = prime * result + pvMax;
		result = prime * result + xpLevel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatistiquePokemon other = (StatistiquePokemon) obj;
		if (def != other.def)
			return false;
		if (defspe != other.defspe)
			return false;
		if (dmg != other.dmg)
			return false;
		if (dmgspe != other.dmgspe)
			return false;
		if (pv != other.pv)
			return false;
		if (pvMax != other.pvMax)
			return false;
		if (xpLevel != other.xpLevel)
			return false;
		return true;
	}
	
	public boolean noPv() {
		if(pv==0) {
			return true;
		}
		return false;
	}
	
	public String pvOnPvMax() {
		return pv+"/"+pvMax;
	}
	
	public double pvRatio() {
		return (double)pv/pvMax;
	}

	public int getXpLevel() {
		return xpLevel;
	}
	
	public boolean substractDamage(int i) {
		pv-=i;
		if(pv<=0) {
			pv=0;
			return true;
		}
		return false;
	}

	public void restorePv() {
		pv=pvMax;
		
	}
	
	
}	
