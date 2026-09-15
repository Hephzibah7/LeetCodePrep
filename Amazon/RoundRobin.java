/*
Round Robin Allocation — Practice Question

You are given a fixed amount of inventory and a list of customer bids.

Each bid is represented as:

[customerId, quantityRequested, bidAmount, timestamp]

The allocation rules are:

Customers with a higher bid amount have priority over customers with lower bids.
If two customers have the same bid amount, the customer with the earlier timestamp gets priority.
For customers with the same bid amount, allocate inventory round-robin:
In each round, give 1 unit to every customer who still needs inventory.
Continue rounds until either all customers in that bid group are satisfied or inventory runs out.
Only after a higher-bid group is completely satisfied should you move to the next lower-bid group.
If inventory runs out, stop immediately.
Return the IDs of all customers who received zero units.
Example
inventory = 5

bids = [
    [1, 3, 10, 1],
    [2, 2, 20, 2],
    [3, 4, 20, 3],
    [4, 1, 10, 4]
]

Expected output:

[1, 4]
Constraints
1 <= bids.length <= 2 * 10^5
1 <= inventory <= 10^9
1 <= quantityRequested <= 10^9
1 <= bidAmount <= 10^9
1 <= timestamp <= 10^9
*/
import java.util.*;

class Solution {

    static class Data {
        long quantity;
        int id;
        long bid;
        long time;

        Data(long quantity, int id, long bid, long time) {
            this.quantity = quantity;
            this.id = id;
            this.bid = bid;
            this.time = time;
        }
    }

    public List<Integer> work(int inventory, int[][] customers) {

        // Higher bid first.
        // For equal bids, earlier timestamp first.
        Arrays.sort(customers, (a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(b[2], a[2]);
            }
            return Integer.compare(a[3], b[3]);
        });

        List<Integer> ans = new ArrayList<>();

        int n = customers.length;
        int i = 0;

        while (i < n && inventory > 0) {

            // Find one bid group.
            int j = i;
            while (j < n && customers[j][2] == customers[i][2]) {
                j++;
            }

            // Active customers in this bid group.
            List<Data> active = new ArrayList<>();

            for (int k = i; k < j; k++) {
                active.add(new Data(
                        customers[k][1], // quantity
                        customers[k][0], // id
                        customers[k][2], // bid
                        customers[k][3] // timestamp
                ));
            }

            /*
             * Process this bid group completely before
             * moving to the next lower bid.
             */
            while (!active.isEmpty() && inventory > 0) {

                int count = active.size();

                // Minimum remaining quantity among active customers.
                long minQuantity = Long.MAX_VALUE;

                for (Data d : active) {
                    minQuantity = Math.min(minQuantity, d.quantity);
                }

                /*
                 * Number of complete rounds we can give everyone.
                 *
                 * Example:
                 * inventory = 10
                 * 3 active customers
                 * minQuantity = 4
                 *
                 * We can give:
                 * A +4
                 * B +4
                 * C +4
                 *
                 * only if inventory >= 12.
                 *
                 * Otherwise inventory / count determines
                 * the number of complete rounds.
                 */
                long rounds = Math.min(
                        minQuantity,
                        inventory / count);

                if (rounds > 0) {

                    long used = rounds * count;
                    inventory -= (int) used;

                    for (Data d : active) {
                        d.quantity -= rounds;
                    }

                } else {

                    /*
                     * Not enough inventory for another complete
                     * round.
                     *
                     * Give one unit to each customer in
                     * timestamp order until inventory runs out.
                     */
                    for (int k = 0; k < active.size() && inventory > 0; k++) {
                        active.get(k).quantity--;
                        inventory--;
                    }
                }

                /*
                 * Remove customers who have now received
                 * everything they requested.
                 */
                active.removeIf(d -> d.quantity == 0);
            }

            /*
             * If inventory is exhausted, every customer remaining
             * in this group and all lower-bid groups gets zero
             * units from this point onward.
             */
            if (inventory == 0) {

                for (Data d : active) {
                    ans.add(d.id);
                }

                for (int k = j; k < n; k++) {
                    ans.add(customers[k][0]);
                }

                break;
            }

            i = j;
        }

        return ans;
    }
}