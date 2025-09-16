## Compose Login Demo

Projekt demonstracyjny pokazujący jak zbudować prostą aplikację logowania w podejściu multiplatformowym (Android + iOS) z wykorzystaniem Compose Multiplatform. Celem było stworzenie wspólnej warstwy UI oraz podstawowych elementów: formularz logowania, walidacja prostych pól, lista przykładowych powiadomień / elementów.

### Główne założenia
- Wspólna logika i interfejs w module `composeApp`
- Oddzielne entry-pointy dla Android (`MainActivity`) i iOS (Swift + osadzony ComposeView)
- Minimalna konfiguracja – skupienie na działającym przepływie buildów i zasobach
- Ikony i zasoby graficzne korzystają z systemu resources Compose

### Struktura katalogów
- `composeApp/src/commonMain` – wspólne UI i logika
- `composeApp/src/androidMain` – specyficzne dla Androida (Manifest, ewentualne integracje)
- `composeApp/src/iosMain` – konfiguracja pod iOS (framework, eksport)
- `iosApp/` – natywna aplikacja iOS (Swift, konfiguracja uruchomienia)

### Użyte biblioteki / technologie (bez wersji)
- Compose Multiplatform (runtime, foundation, ui, material3, ikony rozszerzone)
- Lifecycle (ViewModel + runtime dla Compose)
- Activity Compose (integracja na Androidzie)
- System zasobów Compose (obrazy / drawables)

### Funkcjonalności
- Ekran logowania z podstawową walidacją
- Pola tekstowe w Compose
- Obsługa ikon (Material Icons)
- Prosta lista elementów / powiadomień
- Wspólny kod UI między Android i iOS

### Jak zbudować
Android (debug APK):
```bash
./gradlew :composeApp:assembleDebug
```
Android (release APK):
```bash
./gradlew :composeApp:assembleRelease
```
Android App Bundle (AAB):
```bash
./gradlew :composeApp:bundleRelease
```

iOS (uruchomienie w Xcode):
1. Otwórz katalog `iosApp/iosApp.xcodeproj` w Xcode
2. Wybierz schemat aplikacji
3. Wybierz urządzenie (Simulator lub fizyczne)
4. Build & Run

Framework iOS (generowany przez KMP) buduje się automatycznie przy uruchomieniu z Xcode (arm64 / simulator).

### Generowanie paczek instalacyjnych
- Android: pliki APK / AAB znajdziesz w `composeApp/build/outputs/`
- iOS: IPA można wygenerować z Xcode (Archive -> Distribute) przy użyciu standardowego procesu