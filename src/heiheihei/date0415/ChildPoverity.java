package heiheihei.date0415;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @Description ChildPoverity
 * @Author liuxiao
 * @Date 2017/4/15
 */
public class ChildPoverity {

	public static void main(String[] args) {
		ChildPoverity m = new ChildPoverity();
		City[] cities = m.readData(args[0]);
		m.writeData(args[1], cities);

	}

	private City[] readData(String sourcePath) {
		File file = new File(sourcePath);
		BufferedReader reader = null;
		City[] cities = new City[200];
		try {
			reader = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = reader.readLine()) != null) {
				int state = Integer.parseInt(s.substring(0, 2).trim());
				if (cities[state] == null) {
					cities[state] = new City(Integer.parseInt(s.substring(0, 2).trim()),
							Integer.parseInt(s.substring(82, 90).trim()),
							Integer.parseInt(s.substring(91, 99).trim()),
							Integer.parseInt(s.substring(100, 108).trim()));
				} else {
					City currCity = cities[state];
					currCity.setPopulation(currCity.getPopulation() + Integer.parseInt(s.substring(82, 90).trim()));
					currCity.setChildPopulation(currCity.getChildPopulation() + Integer.parseInt(s.substring(91, 99).trim()));
					currCity.setChildPoverityPopulation(currCity.getChildPoverityPopulation() + Integer.parseInt(s.substring(100, 108).trim()));
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		} catch (NumberFormatException ne) {
			System.out.println("Number Format Exception");
			ne.printStackTrace();
		}
		return cities;
	}

	private void writeData(String targetPath, City[] cities) {
		String s = "State  Population  Child Population  Child Poverity Population  % Child Poverity\n" +
				"-----  ----------  ----------------  -------------------------  ----------------\n";
		try {
			FileWriter writer = new FileWriter(targetPath);
			writer.write(s);
			for (City city : cities) {
				if (city == null) {
					continue;
				}
				String state = "   " + (city.getState() < 10 ? "0" : "") + city.getState();
				DecimalFormat df = new DecimalFormat("#,###");
				String pop = format(df.format(city.getPopulation()), 10);
				String childPop = format(df.format(city.getChildPopulation()), 16);
				String childPovPop = format(df.format(city.getChildPoverityPopulation()), 25);
				df = new DecimalFormat("#.00");
				double per = 100 * (double) city.getChildPoverityPopulation() / (double) city.getChildPopulation();
				String childPovPopPer = format(df.format(per), 16);
				writer.write(state + "  " + pop + "  " + childPop + "  " + childPovPop + "  " + childPovPopPer + "\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String format(String num, int length) {
		int lenOfBlank = length - num.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lenOfBlank; i++) {
			sb.append(" ");
		}
		return sb.append(num).toString();
	}

	private class City {
		private int state;
		private int population;
		private int childPopulation;
		private int childPoverityPopulation;

		public City(int state, int population, int childPopulation, int childPoverityPopulation) {
			this.state = state;
			this.population = population;
			this.childPopulation = childPopulation;
			this.childPoverityPopulation = childPoverityPopulation;
		}

		public int getState() {
			return state;
		}

		public int getPopulation() {
			return population;
		}

		public int getChildPopulation() {
			return childPopulation;
		}

		public int getChildPoverityPopulation() {
			return childPoverityPopulation;
		}

		public void setState(int state) {
			this.state = state;
		}

		public void setPopulation(int population) {
			this.population = population;
		}

		public void setChildPopulation(int childPopulation) {
			this.childPopulation = childPopulation;
		}

		public void setChildPoverityPopulation(int childPoverityPopulation) {
			this.childPoverityPopulation = childPoverityPopulation;
		}
	}

}
