
build: gradlew
	./gradlew build

clean: gradlew
	./gradlew clean

install: ./scripts/install-app.sh
	./install-app.sh

emulator: ./scripts/launch-emulator.sh
	./scripts/launch-emulator.sh
