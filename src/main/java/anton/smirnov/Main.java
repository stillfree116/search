package anton.smirnov;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Path finds = new Path();
		switch (args.length) {
			case 2:
				finds.setSavePath(args[1]);
			case 1:
				finds.setSearchPath(args[0]);
				finds.start();
				break;
			case 0:
				System.out.println("Введи хотя бы каталог для поиска");
				break;
			default:
				System.out.println("Чёт слишком много аргументов");
				break;
		}
	}
}