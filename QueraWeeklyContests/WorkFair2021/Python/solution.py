# https://quera.ir/contest/assignments/32558/problems/109580

class MyError(Exception):
    def __init__(self):
        self.already_printed = True
        print('invalid query')


class Piece:
    def __init__(self, sort, color, position):
        self.role = sort
        self.color = color
        self.position = position
        self.position_hash = hash(position)


class Board():
    def __init__(self):
        self.position = dict()
        white_king = Piece('K', 'white', (-10, -10))
        black_king = Piece('K', 'black', (10, 10))
        self.position[white_king.position_hash] = white_king
        self.position[black_king.position_hash] = black_king

    def validate_add(self, piece, king_move=False):
        if king_move:
            if piece.position_hash in self.position and self.position[piece.position_hash].role != 'K':
                return False
            else:
                return True
        if piece.role != 'P':
            return False
        elif piece.position_hash in self.position:
            return False
        else:
            return True

    def add(self, piece):
        if self.validate_add(piece):
            self.position[piece.position_hash] = piece
        else:
            print('invalid query')

    def validate_remove(self, position_hash, king_move=False):
        piece = self.position.get(position_hash, None)
        if piece and (piece.role == 'P' or king_move):
            return True
        else:
            return False

    def remove(self, position): 
        position_hash = hash(position)
        if self.validate_remove(position_hash):
            del self.position[position_hash]
        else:
            print("invalid query")

    def move(self, piece: Piece, position2):
        new_piece = Piece(sort=piece.role, color=piece.color, position=position2)




    def is_mate(self, color):
        pass

