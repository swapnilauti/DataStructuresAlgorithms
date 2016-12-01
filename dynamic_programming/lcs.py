def lcs(s1,s2):
    """
    :param s1: String 1
    :param s2: String 2
    :return: Length of longest common subsequence
    """
    arr = [[0]*(len(s1)+1) for i in range(len(s2)+1)]
    i =1
    for c2 in s2:
        j=1
        for c1 in s1:
            if c1==c2:
                arr[i][j]=arr[i-1][j-1]+1
            else:
                arr[i][j]=int(max(arr[i-1][j],arr[i][j-1]))
            j+=1
        i+=1
    return arr[len(s2)][len(s1)]

print(lcs("aadfabfafc","abcd"))
