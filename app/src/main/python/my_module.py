
import numpy as np

def get_exec_details():
    return __file__

def sumOp( nums ):
    return sum( nums )

def powOp( a , x ):
    return a**x

def npMatrixSum( m , n ):
    mat = np.ones( ( m , n ) )
    mat_sum = np.sum( mat , axis=1 )
    return mat_sum

class Operations:

    num_ops = 2

    def meanOp( self , nums ):
        return sum( nums ) / len( nums )

    def maxOp( self , nums ):
        return max( nums )

nums_len = 10
nums_len_str = "ten"
ops = Operations()


def npMatrixSum( m , n ):
    mat = np.ones( ( m , n ) )
    mat_sum = np.sum( mat , axis=1 )
    return mat_sum