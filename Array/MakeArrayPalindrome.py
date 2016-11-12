class Abc:
    """
    Find minimum count of merge operations required to make array palindrome. Only sum of 2 adjacent numbers are allowed

    """
    count = 0

    def fun(self, arr, i, j):
        if i > j:
            return []
        f = arr[i]
        l = arr[j]
        if f != l:
            while (i < j) and (f != l):
                if f < l:
                    i += 1
                    f += arr[i]
                else:
                    j -= 1
                    l += arr[j]
                self.count += 1
            if i <= j - 1:
                self.count += 1
                return [f + l]
        ret = [f]
        temp = self.fun(arr, i + 1, j - 1)
        if not temp:
            return ret
        ret.extend(temp)
        ret.append(f)
        return ret


arr = [11, 14, 15, 99]
i = 0
j = len(arr) - 1
a = Abc()
print (a.fun(arr, i, j))
print (a.count)
