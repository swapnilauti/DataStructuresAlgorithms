def coin(n,s):
    """

    :param n: sum
    :param s: list of coins
    :return: number of combinations of coins which sum up to n
    """
    arr = [1]
    arr.extend([0]*n)
    arr = [arr for i in range(len(s)+1)]
    for i in range(1,len(s)+1):
        for j in range(1,n+1):
            arr[i][j]=arr[i-1][j]
            if(j-s[i-1])>=0:
                arr[i][j]+=arr[i][j-s[i-1]]
    return arr[len(s)][n]
print(coin(10,[2,5,3,6]))