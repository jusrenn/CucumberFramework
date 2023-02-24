@Google
Feature: US1001 Kullanici Google'da arama testi yapar

  Scenario Outline: TC01 Kullanici Google'da arama yapabilmeli
    * Google anasayfasina git
    * SearchBox'a "<String>" yi yaz ve enter'a bas
    * Aramanin basariyla yapildigini kontrol et
    * Browser'i kapat

    Examples:
    |String   |
    |Java     |
    |Cucumber |