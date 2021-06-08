package model.pokemon.pokemons;

import java.util.HashMap;
import java.util.Map;

public enum EnumPokemonType implements Comparable<EnumPokemonType>{
	None,
	ACIER,
	FIGHTHING,
	DRAGON,
	WATER,
	ELECTRIC,
	FAIRY,
	FIRE,
	ICE,
	BUG,
	NORMAL,
	GRASS,
	POISON,
	PSYCHIC,
	ROCK,
	GROUND,
	GHOST,
	DARK,
	FLYING;
	
	private static final HashMap<EnumPokemonType, String> TypeToString = new HashMap<EnumPokemonType, String>()
	{{
		put(EnumPokemonType.POISON,"poison");
		put( EnumPokemonType.FLYING,"flying");
		put( EnumPokemonType.GROUND,"ground");
		put(EnumPokemonType.FAIRY,"fairy" );
		put(EnumPokemonType.GRASS,"grass");
		put(EnumPokemonType.FIGHTHING,"fighting");
		put(EnumPokemonType.PSYCHIC,"psychic");
		put(EnumPokemonType.ACIER,"steel");
		put(EnumPokemonType.ICE,"ice");
		put(EnumPokemonType.ROCK,"rock");
		put( EnumPokemonType.WATER,"water");
		put( EnumPokemonType.ELECTRIC,"electric");
		put( EnumPokemonType.DRAGON,"dragon");
		put( EnumPokemonType.DARK,"dark");
		put(EnumPokemonType.GHOST,"ghost");
		put( EnumPokemonType.BUG,"bug");
		put( EnumPokemonType.FIRE,"fire");
		put( EnumPokemonType.NORMAL,"Normal");
	}};
	
	private static final HashMap<String, EnumPokemonType> stringToType = new HashMap<String, EnumPokemonType>()
	{{
		put("poison", EnumPokemonType.POISON);
		put("flying", EnumPokemonType.FLYING);
		put("ground", EnumPokemonType.GROUND);
		put("fairy", EnumPokemonType.FAIRY);
		put("grass", EnumPokemonType.GRASS);
		put("fighting", EnumPokemonType.FIGHTHING);
		put("psychic", EnumPokemonType.PSYCHIC);
		put("steel", EnumPokemonType.ACIER);
		put("ice", EnumPokemonType.ICE);
		put("rock", EnumPokemonType.ROCK);
		put("water", EnumPokemonType.WATER);
		put("electric", EnumPokemonType.ELECTRIC);
		put("dragon", EnumPokemonType.DRAGON);
		put("dark", EnumPokemonType.DARK);
		put("ghost", EnumPokemonType.GHOST);
		put("bug", EnumPokemonType.BUG);
		put("fire", EnumPokemonType.FIRE);
		put("normal", EnumPokemonType.NORMAL);
	}};
	
	/**
	 * Return a EnumPokemonType that correspond to the specified string
	 * @param s
	 * @return
	 */
	public static EnumPokemonType fromString(String s) {
		String test = "test";
		test = s.replaceAll("\\s", "");
		
		return EnumPokemonType.stringToType.get(test);
	}
	
	public String toString() {
		return EnumPokemonType.stringToType.entrySet().stream().filter(entry->EnumPokemonType.this.equals(entry.getValue())).map(Map.Entry<String,EnumPokemonType>::getKey).iterator().next();
	}
	
	
	
}
