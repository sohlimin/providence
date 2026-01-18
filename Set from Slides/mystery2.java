void mystery2(int n) {
	if (n > 0) {
		mystery2(n/10);
		System.out.print(n%10);
	}
}

void main() {

mystery2(3902);
}
