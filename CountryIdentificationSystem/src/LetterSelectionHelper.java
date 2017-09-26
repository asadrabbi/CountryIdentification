
public class LetterSelectionHelper {

	private String string_query;

	public String get_startwith_query(String queryp, String letter) {
		string_query = queryp;

		if (letter.equals("any")) {
			if (string_query.contains("startswith")) {
				String temp[] = string_query.split("startswith");
				temp[1] = temp[1].substring(6);

				if (temp[1] == "") {
					temp[0] = set_dot(temp[0]);
				} else {
					temp[0] = set_comma(temp[0]);

				}
				string_query = temp[0] + temp[1];
			}

		} else {
			if (string_query.contains("startswith")) {
				String temp[] = string_query.split("startswith");

				int i = 0;
				char[] b = temp[1].toCharArray();
				for (i = 0; i <= b.length - 1; i++) {
					if (b[i] == ')') {
						break;
					}

				}
				temp[1] = temp[1].substring(i + 2);
				temp[0] = set_comma(temp[0]);

				string_query = temp[0] + temp[1];
			}

			string_query = set_comma(string_query);
			string_query += "startswith(" + letter + ",X).";

		}

		string_query = set_dot(string_query);
		return string_query;
	}

	private String set_dot(String org_query) {
		String query = org_query;

		if (!(query.length() > 0)) {
			return query;
		}
		char[] charQuery = query.toCharArray();

		charQuery[charQuery.length - 1] = '.';
		query = String.valueOf(charQuery);
		return query;

	}

	private String set_comma(String org_query) {

		String query = org_query;

		if (!(query.length() > 0)) {
			return query;
		}

		char[] charQuery = query.toCharArray();
		charQuery[charQuery.length - 1] = ',';
		query = String.valueOf(charQuery);

		return query;
	}

}
