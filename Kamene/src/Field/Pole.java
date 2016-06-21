package Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Field.Kocka.State;

public class Pole {

	private final Kocka[][] kocky;

	private final int rowCount;

	private final int columnCount;

	private final int plneKocky;
	int x = 0;
	int y = 0;

	public Pole(int rowCount, int columnCount, int plneKocky) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.plneKocky = plneKocky;
		kocky = new Kocka[rowCount][columnCount];

	}

	public void printGame() {

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if (kocky[i][j] instanceof Clue) {
					System.out.print(" " + kocky[i][j].getValue() + " " );
				} else
					System.out.print(" * ");
			}
			System.out.println();
		}

	}

	public void generateGame() {
		int n = -1;

		for (int i = 0; i < columnCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				int a = Shufle();
				n++;
				if (n < getPlneKocky()) {
					kocky[i][j] = new Clue(a);
					kocky[i][j].setState(State.FULL);

				} else {

					kocky[i][j] = new emptyClue();
					kocky[i][j].setState(State.EMPTY);
				}

			}
			
		}

	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getPlneKocky() {
		return plneKocky;
	}

	public int Shufle() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int value = 0;
		Random random = new Random();
		for (int i = 0; i < getPlneKocky(); i++) {
			value = random.nextInt(plneKocky) + 1;
			list.add(value);
		}

		// for (int i : list ){
		// if ()
		// }

		return value;

	}

	public Kocka findEmpty() {
		Kocka kocka = null;
		for (int i = 0; i < getColumnCount(); i++) {
			for (int j = 0; j < getRowCount(); j++) {
				if (kocky[i][j] instanceof emptyClue) {
					x = i;
					y = j;
					kocka = kocky[x][y];
				}
			}

		}

		x++;
		y++;
		System.out.println("Prazda kocka je na pozicii X:" + x + "  Y: " + y);
		return kocka;
	}

	public void moveUp() {
		findEmpty();
		if (y < getRowCount()) {
			Kocka kocka = kocky[x][y];
			System.out.println(" hodnota kocky " + kocky[x][y].getValue());
			kocky[x][y] = kocky[x - 1][y];
			kocky[x - 1][y] = kocka;
	}

	}

	public void moveDown() {
		findEmpty();
		if (x < getRowCount()) {
			Kocka kocka = kocky[x][y];
			kocky[x][y] = kocky[x - 1][y];
			kocky[x + 1][y] = kocka;

		}
		
		

	}

	public void moveLeft() {
		findEmpty();
		if (x < getRowCount()) {
			Kocka kocka = kocky[x][y];
			kocky[x][y] = kocky[x - 1][y];
			kocky[x][y + 1] = kocka;

		}

	}

	public void moveRight() {
		findEmpty();
		if (x < getRowCount()) {
			Kocka kocka = kocky[x][y];
			kocky[x][y] = kocky[x - 1][y];
			kocky[x][y - 1] = kocka;
		}

	}

}
