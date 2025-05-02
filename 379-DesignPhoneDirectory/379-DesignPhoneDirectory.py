"""

379. Design Phone Directory

Design a phone directory that initially has maxNumbers empty slots that can store numbers. The directory should store numbers, check if a certain slot is empty or not, and empty a given slot.

Implement the PhoneDirectory class:

    PhoneDirectory(int maxNumbers) Initializes the phone directory with the number of available slots maxNumbers.
    int get() Provides a number that is not assigned to anyone. Returns -1 if no number is available.
    bool check(int number) Returns true if the slot number is available and false otherwise.
    void release(int number) Recycles or releases the slot number.

Example 1:

Input
["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]
[[3], [], [], [2], [], [2], [2], [2]]
Output
[null, 0, 1, true, 2, false, null, true]

Explanation
PhoneDirectory phoneDirectory = new PhoneDirectory(3);
phoneDirectory.get();      // It can return any available phone number. Here we assume it returns 0.
phoneDirectory.get();      // Assume it returns 1.
phoneDirectory.check(2);   // The number 2 is available, so return true.
phoneDirectory.get();      // It returns 2, the only number that is left.
phoneDirectory.check(2);   // The number 2 is no longer available, so return false.
phoneDirectory.release(2); // Release number 2 back to the pool.
phoneDirectory.check(2);   // Number 2 is available again, return true.

Constraints:

    1 <= maxNumbers <= 104
    0 <= number < maxNumbers
    At most 2 * 104 calls will be made to get, check, and release.

"""

class PhoneDirectory:

    def __init__(self, maxNumbers: int):
        self.q = deque()
        for i in range(maxNumbers): self.q.append(i)
        self.maxx = maxNumbers
        self.vis = set()

    def get(self) -> int:
        q = self.q
        vis = self.vis
        if len(q) == 0: return -1
        vis.add(q[0])
        return q.popleft()

    def check(self, number: int) -> bool:
        vis = self.vis
        if number < 0 or number > self.maxx: return False
        if number in vis: return False
        return True
        
    def release(self, number: int) -> None:
        vis = self.vis
        q = self.q
        if number in vis:
            vis.remove(number)
            q.append(number)
        
        


# Your PhoneDirectory object will be instantiated and called as such:
# obj = PhoneDirectory(maxNumbers)
# param_1 = obj.get()
# param_2 = obj.check(number)
# obj.release(number)
