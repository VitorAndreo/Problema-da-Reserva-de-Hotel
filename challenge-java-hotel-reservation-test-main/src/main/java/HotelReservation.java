import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

	public String getCheapestHotel(String input) {

		// Getting type of guest and day of week
		String type = input.split(":")[0];
		List<String> dayWeek = new ArrayList<>();

		// Hotels
		Lakewood lakewood = new Lakewood();
		Bridgewood bridgewood = new Bridgewood();
		Ridgewood ridgewood = new Ridgewood();

		// Counter: regular week or weekend
		Integer countA = 0;// Regular Week
		Integer countB = 0;// Weekend

		// Hotel prices
		Integer priceLakewoodRegular = 0;
		Integer priceLakewoodRewards = 0;
		Integer priceBridgewoodRegular = 0;
		Integer priceBridgewoodRewards = 0;
		Integer priceRidgewoodRegular = 0;
		Integer priceRidgewoodRewards = 0;

		// Hotel classification
		Integer bestClassification = 0;

		// Cheapest Hotel variable return
		String cheapestHotel = "";

		if (type.equals("Regular")) {

			List<String> dayOfWeek = Arrays.asList(input.split(":")[1].split(","));

			dayOfWeek.forEach(week -> {
				String stringWeek = week.trim().substring(10, 13);
				dayWeek.add(stringWeek);

			});

			for (int i = 0; i < dayOfWeek.size(); i++) {
				if (dayWeek.get(i).equals("sat") || dayWeek.get(i).equals("sun")) {

					countA++;

				} else {
					countB++;

				}
			}
			priceLakewoodRegular = countB * lakewood.taxRegularWeekRegGuest + countA * lakewood.taxWeekendRegGuest;
			priceBridgewoodRegular = countB * bridgewood.taxRegularWeekRegGuest
					+ countA * bridgewood.taxWeekendRegGuest;
			priceRidgewoodRegular = countB * ridgewood.taxRegularWeekRegGuest + countA * ridgewood.taxWeekendRegGuest;

			if (priceLakewoodRegular != priceBridgewoodRegular && priceBridgewoodRegular != priceRidgewoodRegular
					&& priceLakewoodRegular != priceRidgewoodRegular) {
				if (priceLakewoodRegular < priceBridgewoodRegular && priceLakewoodRegular < priceRidgewoodRegular) {
					cheapestHotel = lakewood.name;
				} else if (priceBridgewoodRegular < priceLakewoodRegular
						&& priceBridgewoodRegular < priceRidgewoodRegular) {
					cheapestHotel = bridgewood.name;
				} else {
					cheapestHotel = ridgewood.name;
				}

			} else {
				if (priceBridgewoodRegular == priceLakewoodRegular) {
					bestClassification = bridgewood.classification;
				} else if (priceLakewoodRegular == priceRidgewoodRegular) {
					bestClassification = ridgewood.classification;
				} else if (priceBridgewoodRegular == priceRidgewoodRegular) {
					bestClassification = ridgewood.classification;
				} else {
					bestClassification = lakewood.classification;
				}

				switch (bestClassification) {
				case 3:
					cheapestHotel = lakewood.name;
				case 4:
					cheapestHotel = bridgewood.name;
				case 5:
					cheapestHotel = ridgewood.name;
				}
			}

		} else {// Rewards
			List<String> dayOfWeek = Arrays.asList(input.split(":")[1].split(","));
			dayOfWeek.forEach(week -> {
				String stringWeek = week.trim().substring(10, 13);
				dayWeek.add(stringWeek);

			});

			for (int i = 0; i < dayOfWeek.size(); i++) {
				if (dayWeek.get(i).equals("sat") || dayWeek.get(i).equals("sun")) {
					countA++;
				} else {
					countB++;

				}
			}
			priceLakewoodRewards = countB * lakewood.taxRegularWeekRewGuest + countA * lakewood.taxWeekendRewGuest;
			priceBridgewoodRewards = countB * bridgewood.taxRegularWeekRewGuest
					+ countA * bridgewood.taxWeekendRewGuest;
			priceRidgewoodRewards = countB * ridgewood.taxRegularWeekRewGuest + countA * ridgewood.taxWeekendRewGuest;

			if (priceLakewoodRewards != priceBridgewoodRewards && priceBridgewoodRewards != priceRidgewoodRewards
					&& priceLakewoodRewards != priceRidgewoodRewards) {
				if (priceLakewoodRewards < priceBridgewoodRewards && priceLakewoodRewards < priceRidgewoodRewards) {
					cheapestHotel = lakewood.name;
				} else if (priceBridgewoodRewards < priceLakewoodRewards
						&& priceBridgewoodRewards < priceRidgewoodRewards) {
					cheapestHotel = bridgewood.name;
				} else {
					cheapestHotel = ridgewood.name;
				}

			} else {
				if (priceBridgewoodRewards == priceLakewoodRewards) {
					bestClassification = bridgewood.classification;
				} else if (priceLakewoodRewards == priceRidgewoodRewards) {
					bestClassification = ridgewood.classification;
				} else if (priceBridgewoodRewards == priceRidgewoodRewards) {
					bestClassification = ridgewood.classification;
				} else {
					bestClassification = lakewood.classification;
				}

				switch (bestClassification) {
				case 3:
					cheapestHotel = lakewood.name;
				case 4:
					cheapestHotel = bridgewood.name;
				case 5:
					cheapestHotel = ridgewood.name;
				}
			}

		}

		return cheapestHotel.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		HotelReservation hotel = new HotelReservation();

		System.out.println(hotel.getCheapestHotel(input));

		sc.close();

	}
}
