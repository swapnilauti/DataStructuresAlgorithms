def lis(arr):
    """
    :param arr: list of integers
    :return: list of same dimensions as that of arr, where integer at every index represents
    a number of elements befor index, smaller than the element at that index in arr
    """
    ret = [1]
    for i in range(1,len(arr)):
        max=0
        for j in range(i):
            if arr[i]>arr[j] and ret[j]>max:
                max=ret[j]
        ret.append(max+1)
    return ret

def lds(arr):
    """
    :param arr: list of integers
    :return: list of same dimensions as that of arr, where integer at every index represents
    a number of elements after index, greater than the element at that index in arr
    """
    ret = [1]*len(arr)
    for i in range(len(arr)-2,-1,-1):
        max=0
        for j in range(len(arr)-1,i,-1):
            if arr[i]>arr[j] and ret[j]>max:
                max=ret[j]
        ret[i]=max+1
    return ret

def bitonic(arr):
    """
    :param arr: list of numbers
    :return: length of longest bitonic subsequence for arr
    """
    l1 = lis(arr)
    l2 = lds(arr)
    max = 0
    for i in range(len(arr)):
        if l1[i]+l2[i]>max:
            max = l1[i]+l2[i]-1
    return max
print (bitonic([80, 60, 30, 40, 20, 10]))
