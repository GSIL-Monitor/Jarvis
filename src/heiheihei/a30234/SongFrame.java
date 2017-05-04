package heiheihei.a30234;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/23
 */
public class SongFrame extends JFrame implements ActionListener {

	private String dbPath = "mySongDB.txt";

	private Map<String, Song> mSongDBMap;
	private JLabel mSongSelectorLabel;
	private JLabel mItemCodeLabel;
	private JLabel mDescriptionLabel;
	private JLabel mArtistLabel;
	private JLabel mAlbumLabel;
	private JLabel mPriceLabel;
	private JComboBox<String> mSongSelector;
	private JTextField mItemCodeTxt;
	private JTextField mDescriptionTxt;
	private JTextField mArtistTxt;
	private JTextField mAlbumTxt;
	private JTextField mPriceTxt;
	private JButton addBtn;
	private JButton editBtn;
	private JButton deleteBtn;
	private JButton acceptBtn;
	private JButton cancelBtn;
	private JButton exitBtn;

	private int currCommand; //1-add 2-edit 3-delete

	public SongFrame() {
		this.setSize(420, 340);
		this.setTitle("Song Table");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initField(true);
		initLayout();
		doInit();
		this.setVisible(true);
	}

	public SongFrame(String dbPath, boolean ifLoadLocal) {
		this.dbPath = dbPath;
		this.setSize(420, 340);
		this.setTitle("Song Table");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initField(ifLoadLocal);
		initLayout();
		doInit();
		this.setVisible(true);
	}

	private void initField(boolean ifLoadLocal) {
		mSongDBMap = new HashMap<>();
//		initExampleSongMap();
		if (ifLoadLocal) {
			File dbFile = new File(dbPath);
			try {
				loadData(dbFile);
			} catch (Exception e) {
				System.out.println("Wrong db file.");
			}
		}
	}

	private void initLayout() {
		mSongSelectorLabel = new JLabel("Select Song: ");
		mSongSelectorLabel.setBounds(30, 20, 100, 30);
		this.add(mSongSelectorLabel);

		mSongSelector = new JComboBox<>();
		mSongSelector.setBounds(130, 20, 250, 30);
		this.add(mSongSelector);

		mItemCodeLabel = new JLabel("Item Code: ");
		mItemCodeLabel.setBounds(30, 50, 100, 30);
		this.add(mItemCodeLabel);

		mItemCodeTxt = new JTextField();
		mItemCodeTxt.setBounds(130, 50, 250, 30);
		this.add(mItemCodeTxt);

		mDescriptionLabel = new JLabel("Description: ");
		mDescriptionLabel.setBounds(30, 80, 100, 30);
		this.add(mDescriptionLabel);

		mDescriptionTxt = new JTextField();
		mDescriptionTxt.setBounds(130, 80, 250, 30);
		this.add(mDescriptionTxt);

		mArtistLabel = new JLabel("Artist: ");
		mArtistLabel.setBounds(30, 110, 100, 30);
		this.add(mArtistLabel);

		mArtistTxt = new JTextField();
		mArtistTxt.setBounds(130, 110, 250, 30);
		this.add(mArtistTxt);

		mAlbumLabel = new JLabel("Album: ");
		mAlbumLabel.setBounds(30, 140, 100, 30);
		this.add(mAlbumLabel);

		mAlbumTxt = new JTextField();
		mAlbumTxt.setBounds(130, 140, 250, 30);
		this.add(mAlbumTxt);

		mPriceLabel = new JLabel("Price: ");
		mPriceLabel.setBounds(30, 170, 100, 30);
		this.add(mPriceLabel);

		mPriceTxt = new JTextField();
		mPriceTxt.setBounds(130, 170, 250, 30);
		this.add(mPriceTxt);

		addBtn = new JButton("Add");
		addBtn.setBounds(40, 210, 100, 40);
		addBtn.addActionListener(this);
		this.add(addBtn);

		editBtn = new JButton("Edit");
		editBtn.setBounds(160, 210, 100, 40);
		editBtn.addActionListener(this);
		this.add(editBtn);

		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(280, 210, 100, 40);
		deleteBtn.addActionListener(this);
		this.add(deleteBtn);

		acceptBtn = new JButton("Accept");
		acceptBtn.setBounds(40, 255, 100, 40);
		acceptBtn.addActionListener(this);
		this.add(acceptBtn);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(160, 255, 100, 40);
		cancelBtn.addActionListener(this);
		this.add(cancelBtn);

		exitBtn = new JButton("Exit");
		exitBtn.setBounds(280, 255, 100, 40);
		exitBtn.addActionListener(this);
		this.add(exitBtn);
	}

	private void doInit() {
		currCommand = 0;
		enableComponent(mSongSelector);
		disEditableTxt(mItemCodeTxt);
		disEditableTxt(mDescriptionTxt);
		disEditableTxt(mArtistTxt);
		disEditableTxt(mAlbumTxt);
		disEditableTxt(mPriceTxt);
		enableComponent(addBtn);
		enableComponent(editBtn);
		enableComponent(deleteBtn);
		disableComponent(acceptBtn);
		disableComponent(cancelBtn);
		enableComponent(exitBtn);
		initSelector();
	}

	private void loadData(File file) {
		mSongDBMap = new HashMap<>();
		String[] data = FileUtil.readFromFile(file).split("\n");
		for (String s : data) {
			Song song = Song.parseToSong(s);
			mSongDBMap.put(song.getDescription(), song);
		}
	}

	private void saveData() {
		StringBuilder data = new StringBuilder();
		for (String songName : mSongDBMap.keySet()) {
			data.append(mSongDBMap.get(songName)).append('\n');
		}
		FileUtil.writeToFile(dbPath, data.toString());
	}

	private void initExampleSongMap() {
		Song song1 = Song.getExampleSong1();
		Song song2 = Song.getExampleSong2();
		Song song3 = Song.getExampleSong3();
		mSongDBMap.put(song1.getDescription(), song1);
		mSongDBMap.put(song2.getDescription(), song2);
		mSongDBMap.put(song3.getDescription(), song3);
		saveData();
	}

	private void initSelector() {
		mSongSelector.removeAllItems();
		for (String songName : mSongDBMap.keySet()) {
			mSongSelector.addItem(songName);
		}
		updateTxtsData((String) mSongSelector.getSelectedItem());
		mSongSelector.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				switch (event.getStateChange()) {
					case ItemEvent.SELECTED:
						String songName = (String) event.getItem();
						updateTxtsData(songName);
						break;
					case ItemEvent.DESELECTED:
						break;
				}
			}
		});
	}

	private void updateTxtsData(String songName) {
		if (songName == null || songName.equals("")) {
			return;
		}
		Song currSong = mSongDBMap.get(songName);
		mItemCodeTxt.setText(currSong.getItemCode());
		mDescriptionTxt.setText(currSong.getDescription());
		mArtistTxt.setText(currSong.getArtist());
		mAlbumTxt.setText(currSong.getAlbum());
		mPriceTxt.setText(String.valueOf(currSong.getPrice()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().toLowerCase()) {
			case "add":
				mSongSelector.setEnabled(false);
				clearAndEnable(mItemCodeTxt);
				clearAndEnable(mDescriptionTxt);
				clearAndEnable(mArtistTxt);
				clearAndEnable(mAlbumTxt);
				clearAndEnable(mPriceTxt);
				disableComponent(editBtn);
				disableComponent(deleteBtn);
				enableComponent(acceptBtn);
				enableComponent(cancelBtn);
				currCommand = 1;
				break;
			case "edit":
				disableComponent(mSongSelector);
				disEditableTxt(mItemCodeTxt);
				enEditableTxt(mDescriptionTxt);
				enEditableTxt(mArtistTxt);
				enEditableTxt(mAlbumTxt);
				enEditableTxt(mPriceTxt);
				disableComponent(addBtn);
				disableComponent(editBtn);
				disableComponent(deleteBtn);
				enableComponent(acceptBtn);
				enableComponent(cancelBtn);
				currCommand = 2;
				break;
			case "delete":
				doDeleteSong();
				break;
			case "accept":
				switch (currCommand) {
					case 1:
						doAddSong();
						break;
					case 2:
						doEditSong();
						break;
				}
				break;
			case "cancel":
				doInit();
				break;
			case "exit":
				saveData();
				System.exit(0);
				break;
		}
	}

	private void doAddSong() {
		String itemCode = mItemCodeTxt.getText();
		String description = mDescriptionTxt.getText();
		String artist = mArtistTxt.getText();
		String album = mAlbumTxt.getText();
		double price;
		try {
			price = Double.parseDouble(mPriceTxt.getText());
		} catch (NumberFormatException nfe) {
			showErrorMessage("Invalid data.");
			return;
		}
		if (itemCode == null || description == null || artist == null ||
				itemCode.length() == 0 || description.length() == 0 || artist.length() == 0) {
			showErrorMessage("Input data fully.");
			return;
		}
		if (album == null || album.length() == 0) {
			album = "None";
		}
		Song song = new Song(itemCode, description, artist, album, price);
		mSongDBMap.put(description, song);
		doInit();
		showSuccessMessage("Add song succeed.");
	}

	private void doEditSong() {
		String itemCode = mItemCodeTxt.getText();
		String description = mDescriptionTxt.getText();
		String artist = mArtistTxt.getText();
		String album = mAlbumTxt.getText();
		double price;
		try {
			price = Double.parseDouble(mPriceTxt.getText());
		} catch (NumberFormatException nfe) {
			showErrorMessage("Invalid data.");
			return;
		}
		if (description == null || artist == null || description.length() == 0 || artist.length() == 0) {
			showErrorMessage("Input data fully.");
			return;
		}
		if (album == null || album.length() == 0) {
			album = "None";
		}
		for (String songName : mSongDBMap.keySet()) {
			Song song = mSongDBMap.get(songName);
			if (song.getItemCode().equals(itemCode)) {
				mSongDBMap.remove(songName);
				break;
			}
		}
		Song song = new Song(itemCode, description, artist, album, price);
		mSongDBMap.put(description, song);
		doInit();
		showSuccessMessage("Edit song succeed.");
	}

	private void doDeleteSong() {
		String des = (String) mSongSelector.getSelectedItem();
		mSongDBMap.remove(des);
		doInit();
		showSuccessMessage("Delete song succeed.");
	}

	private void disableComponent(JComponent component) {
		component.setEnabled(false);
	}

	private void enableComponent(JComponent component) {
		component.setEnabled(true);
	}

	private void disEditableTxt(JTextField txt) {
		txt.setEditable(false);
	}

	private void enEditableTxt(JTextField txt) {
		txt.setEditable(true);
	}

	private void clearAndEnable(JTextField txt) {
		txt.setText("");
		txt.setEditable(true);
	}

	private void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void showSuccessMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		new SongFrame();
	}
}
