package org.lazan.t5.graphael.demo.pages;

import org.apache.tapestry5.annotations.Property;

public class PieChartDemo {
	@Property
	private Country country;
	
	public Country[] getCountries() {
		return new Country[] {
			new Country("China", 1361390000, "#37DB79"),
			new Country("India", 1237180000, "#225E79"),
			new Country("United States", 317181000, "#024A68"),
			new Country("Indonesia", 237641326, "#0772A1"),
			new Country("Brazil", 201032714, "#BF7C30"),
			new Country("Pakistan", 184954000, "#A65800"),
			new Country("Nigeria", 173615000, "#FF8700"),
			new Country("Bangladesh", 152518015, "#BF4B30"),
			new Country("Russia", 143600000, "#FF3100"),
			new Country("Japan", 127290000, "#A62000")
		};
	};
	
	public static class Country {
		public String name;
		public int population;
		public String color;
		
		public Country(String name, int population, String color) {
			super();
			this.name = name;
			this.population = population;
			this.color = color;
		}
	}
}
