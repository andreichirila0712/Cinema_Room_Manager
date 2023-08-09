package cinema;

import java.util.Objects;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        int numberOfPurchasedTickets = 0;
        int totalIncome = 0;
        float percentage = 0.00f;
        int currentIncome = 0;

        // STAGE 1 ARRANGEMENT
        /*System.out.println("Cinema:");
        for (int i = 1; i < 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i < 8; i++) {
            System.out.print(i);
            for (int j = 0; j < 8; j++) {
                System.out.print(" S");
            }
            System.out.println("");
        }
        */


        // STAGE 2 SOLD!

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        String[][] cinema = new String[numberOfRows+1][numberOfSeats+1];
        int totalNumberOfSeats = numberOfSeats * numberOfRows;

        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.println();

        cinema[0][0]= " ";
        for (int i = 0; i <= numberOfRows; i++) {
            for (int j = 0; j <= numberOfSeats; j++) {
                if (i == 0) {
                    if ((j+1) <= numberOfSeats) {
                        cinema[0][j+1] = " " + (j + 1);
                    }
                } else if (i > 0 && (j+1) <= numberOfSeats) {
                    cinema[i][0] = String.valueOf(i);
                    cinema[i][j+1] = " S";
                }
            }
        }

        System.out.println("Cinema:");
        for (String[] strings : cinema) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

        int menu = scanner.nextInt();

        while(menu != 0) {
            switch (menu) {
                case 1 -> {
                    System.out.println("Cinema:");
                    for (String[] strings : cinema) {
                        for (String string : strings) {
                            System.out.print(string);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("1. Show the seats");
                    System.out.println("2. Buy a ticket");
                    System.out.println("3. Statistics");
                    System.out.println("0. Exit");
                    System.out.println();
                    menu = scanner.nextInt();
                }
                case 2 -> {
                    int ticketPrice = 0;
                    int rowNumber = 0;
                    int seatNumber = 0;

                    System.out.println("Enter a row number:");
                    rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatNumber = scanner.nextInt();

                    boolean inBoundsRow = (rowNumber < 0) || (rowNumber >= cinema.length);
                    if (inBoundsRow) {
                        System.out.println("Wrong input!");
                        break;
                    }
                    boolean inBoundsSeat = (seatNumber < 0) || (seatNumber >= cinema[rowNumber].length);

                    if (!inBoundsSeat && cinema[rowNumber][seatNumber].equals(" S")) {
                        cinema[rowNumber][seatNumber] = " B";

                        if (totalNumberOfSeats <= 60) {
                            ticketPrice = 10;
                            currentIncome = currentIncome + ticketPrice;
                        } else if (totalNumberOfSeats > 60) {
                            if (rowNumber <= numberOfRows / 2) {
                                ticketPrice = 10;
                                currentIncome = currentIncome + ticketPrice;
                            } else {
                                ticketPrice = 8;
                                currentIncome = currentIncome + ticketPrice;
                            }
                        }

                        System.out.println("Ticket price: $" + ticketPrice);
                        System.out.println();
                        numberOfPurchasedTickets++;
                    } else if (inBoundsSeat) {
                        System.out.println("Wrong input!");
                        break;
                    } else if (cinema[rowNumber][seatNumber].equals(" B")) {
                        System.out.println("That ticket has already been purchased!");
                        break;
                    }




                    System.out.println("1. Show the seats");
                    System.out.println("2. Buy a ticket");
                    System.out.println("3. Statistics");
                    System.out.println("0. Exit");
                    System.out.println();
                    menu = scanner.nextInt();
                }

                case 3 -> {

                    int halfIncome1 = 0;
                    int halfIncome2 = 0;

                    if (totalNumberOfSeats <= 60) {
                        totalIncome = totalNumberOfSeats * 10;
                    } else if (totalNumberOfSeats > 60) {
                        if (numberOfRows % 2 == 0) {
                            halfIncome1 = numberOfRows / 2 * numberOfSeats * 10;
                            halfIncome2 = numberOfRows / 2 * numberOfSeats * 8;
                            totalIncome = halfIncome1 + halfIncome2;
                        } else if (numberOfRows % 2 != 0) {
                            halfIncome1 = numberOfRows / 2 * numberOfSeats * 10;
                            halfIncome2 = (numberOfRows / 2 + 1) * numberOfSeats * 8;
                            totalIncome = halfIncome1 + halfIncome2;
                        }
                    }

                    percentage = ((float) numberOfPurchasedTickets / totalNumberOfSeats) * 100;

                    System.out.printf("Number of purchased tickets: %d", numberOfPurchasedTickets);
                    System.out.println();
                    System.out.printf("Percentage: %.2f%s", percentage,"%");
                    System.out.println();
                    System.out.printf("Current income: $%d", currentIncome);
                    System.out.println();
                    System.out.println("Total income: $" +totalIncome);
                    System.out.println();
                    menu = scanner.nextInt();
                }
            }
        }

        // System.out.println("Total income:$" +totalIncome);



        // STAGE 3 TICKET

        System.out.println("Cinema:");
        for (String[] strings : cinema) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }
}