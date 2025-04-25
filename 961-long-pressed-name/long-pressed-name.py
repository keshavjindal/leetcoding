class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        i = 0
        j = 0

        while i < len(name) and j < len(typed):
            if name[i] == typed[j]:
                i = i + 1
                j = j + 1
            elif j-1>=0 and typed[j] == typed[j - 1]:
                j = j + 1
            else:
                return False

        if j == len(typed) and i < len(name):
            return False

        while j < len(typed):
            if j-1>=0 and typed[j] == typed[j - 1]:
                j = j + 1
            else:
                return False

        return True
