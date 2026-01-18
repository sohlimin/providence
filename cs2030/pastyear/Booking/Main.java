import java.util.stream.Stream;
void main() {} //method

Transaction process(Stream<Transaction> transactions, Init init) {
    return transactions.reduce(init, (x,y) -> y.transact(x));

}


