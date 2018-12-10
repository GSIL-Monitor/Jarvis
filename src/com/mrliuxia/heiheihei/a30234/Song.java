package com.mrliuxia.heiheihei.a30234;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/27
 */
public class Song {

	private String itemCode;
	private String description;
	private String artist;
	private String album;
	private double price;

	public static void main(String[] args) {
		String example = "Song{itemCode=BTO12, description=Yellow Submarine, artist=The Beatles, album=Beatles Greatest Hits 1, price=1.99}";
		Song song = parseToSong(example);
		System.out.println(song);
	}


	public Song(String itemCode, String description, String artist, String album, double price) {
		this.itemCode = itemCode;
		this.description = description;
		this.artist = artist;
		this.album = album;
		this.price = price;
	}

	public static Song getExampleSong1() {
		return parseToSong("Song{itemCode=BTO12, description=Yellow Submarine, artist=The Beatles, album=Beatles Greatest Hits, price=1.99}");
	}

	public static Song getExampleSong2() {
		return parseToSong("Song{itemCode=QT001, description=Qing Tian, artist=Jay Chou, album=YeHuiMei, price=10.00}");
	}

	public static Song getExampleSong3() {
		return parseToSong("Song{itemCode=HP123, description=Wo Hai Pa, artist=Joker Xue, album=Wo Hai Pa, price=0.00}");
	}

	public static Song parseToSong(String s) {
		if (s == null || s.length() == 0) return null;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				count++;
			}
		}
		if (count != 4) {
			throw new RuntimeException("Wrong text formatting");
		}
		s = s.substring(0, s.length() - 1);
		String[] data = s.substring(s.indexOf('{')).split(", ");
		String itemCode = data[0].split("=")[1];
		String description = data[1].split("=")[1];
		String artist = data[2].split("=")[1];
		String album = data[3].split("=")[1];
		double price = Double.parseDouble(data[4].split("=")[1]);
		return new Song(itemCode, description, artist, album, price);
	}

	@Override
	public String toString() {
		return "Song{" +
				"itemCode=" + itemCode +
				", description=" + description +
				", artist=" + artist +
				", album=" + album +
				", price=" + price +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Song song = (Song) o;
		return description.equals(song.description);
	}

	@Override
	public int hashCode() {
		return description.hashCode();
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
