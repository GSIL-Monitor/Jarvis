package ztest;

import java.util.*;
import java.util.List;

/**
 * Created by ztest.Poker on 2016/12/2.,
 */
public class Hello {

	public static void main(String[] args) {
//		String s = "a aaaa b b bb ";
//		System.out.println(s.substring(0, s.indexOf(' ')));
//		s = s.substring(s.indexOf(' ')+1);
//		System.out.println(s.substring(0, s.indexOf(' ')));
//		s = s.substring(s.indexOf(' ')+1);
//		System.out.println(s);
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			System.out.println(scan.next());
			System.out.println(scan.next());
			System.out.println(scan.nextLine().trim());
//			String content = scan.nextLine();
//			content = content.substring(content.indexOf(' ')+1);
//			System.out.println(content);

		}
	}



	public boolean isRightTriangle(int a, int b, int c) {
		int max = a;
		max = b > max ? b : max;
		max = c > max ? c : max;
		int min = a;
		min = b < min ? b : min;
		min = c < min ? c : min;
		int mid = a ^ b ^ c ^ max ^ min;
		return Math.pow(max, 2) - Math.pow(mid, 2) - Math.pow(min, 2) == 0;
	}

//
//	public static void main(String[] args) {
//		new Hello().isRightTriangle(5, 3, 4);
//
//	}

	/**
	 * @param orders    工单id列表
	 * @param workerMap 经办人员权重map
	 * @return Map<经办人员id，List<工单号>>
	 */
	public Map<String, List<String>> allocWorkOrder(List<String> orders, Map<String, Integer> workerMap) {
		if (orders == null || workerMap == null || orders.size() == 0) {
			return null;
		}
		Map<String, List<String>> res = new HashMap<>();
        int sum = 0;
		for (Map.Entry<String, Integer> worker : workerMap.entrySet()) {
			sum += worker.getValue();
		}
		if (orders.size() < sum) {
			return res;
		}
		int currIndex = 0;
		for (Map.Entry<String, Integer> worker : workerMap.entrySet()) {
			List<String> currWorkerOrderList = new ArrayList<>();
			for (int j = 0; j < worker.getValue(); j++) {
				currWorkerOrderList.add(orders.get(currIndex++));
			}
			res.put(worker.getKey(), currWorkerOrderList);
		}
		return res;
	}

	private static List<String> getContent(Map<String, List<String>> map) {
		List<String> list = new LinkedList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getKey() == null) {
				continue;
			}
			for (String s : entry.getValue()) {
				list.add(s);
			}
		}
		return list;
	}

}
