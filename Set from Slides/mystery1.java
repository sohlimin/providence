void mystery1 (int n) {
	if (n > 0) {
		mystery1(n/10);
		System.out.print(n%10);
	}
}

void main() {

mystery1(3902);
}
