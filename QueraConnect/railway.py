class Train:

    def __init__(self, last_visited_city, weight_capacity, is_on_trip):
        self.last_visited_city = last_visited_city
        self.weight_capacity = weight_capacity
        self.is_on_trip = is_on_trip


class Trip:

    def __init__(self, origin_city, destination_city, train):
        self.all_cities = ('Arak', 'Ardabil', 'Urmia', 'Isfahan', 'Ahvaz', 'Ilam', 'Bojnord', 'Bandar Abbas', 'Bushehr', 'Birjand', 'Tabriz', 'Tehran', 'Khorramabad', 'Rasht', 'Zahedan', 'Zanjan', 'Sari', 'Semnan', 'Sanandaj', 'Shahr-e Kord', 'Shiraz', 'Qazvin', 'Qom', 'Karaj', 'Kermanshah', 'Gorgan', 'Mashhad', 'Hamadan', 'Yasuj', 'Yazd')
        self.train = self.train_validation(train)
        self.destination_city = destination_city
        self.origin_city = self.origin_city_validation(origin_city)
        self.passengers = []


    def origin_city_validation(self, origin_city):
        assert origin_city in self.all_cities, Exception('This input is not a verified city!')
        assert origin_city != self.destination_city, Exception('Origin and destination cities can\'t be the same!')
        assert origin_city == self.train.last_visited_city, Exception('The train of the trip is not available in the origin city!')
        return origin_city

    def train_validation(self, train):
        assert isinstance(train, Train), Exception('This input is not a train!')
        assert not train.is_on_trip, Exception('This train is not available!')
        return train

    def __call__(self):
        sum = self.train.weight_capacity
        for p in self.passengers:
            sum -= p.load_weight
        return sum



class Passenger:

    def __init__(self, fullname, load_weight):
        self.fullname = fullname
        self.load_weight = load_weight

    def attend_trip(self, trip):
        if self.load_weight <= trip():
            trip.passengers.append(self)
        else:
            raise Exception('Heavy load!')

    def cancel_trip(self, trip):
        try:
            trip.passengers.remove(self)
        except:
            raise Exception('This passenger is not attended to this trip!')


    def __repr__(self):
        return self.fullname
