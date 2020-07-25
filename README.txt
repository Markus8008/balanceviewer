Po krótce - z e-maila - jakie są założenia dla tego microservice

- wykorzystuje "featury" Javy 1.8
- implementuje endpoint akceptujący jako request payload jsona (definicja na końcu maila)  
- zwraca jsona informujacego dla każdego z klientów o:
	bilansie na dzień wywołania requesta 
	sumarycznym obrocie na koncie od ostatniego dnia z wiadomym balansem do dnia wywołania requesta 
	sumie przychodów od ostatniego dnia z wiadomym balansem do dnia wywołania requesta 
	sumie rozchodów od ostatniego dnia z wiadomym balansem do dnia wywołania requesta 

Jeśli zadanie jest zbyt generyczne, przyjmij sam pewne założenia i wylistuj je.
Kod proszę opublikuj na GitHub i podeślij linka. 


Przykładowy json  

{
  "clients": {
    "client": [
      {
        "info": {
          "name": "Tomasz",
          "surname": "Karcznski"
        },
        "balance": {
          "total": "12110",
          "currency": "PLN",
          "date": "01.05.2020"
        },
        "transactions": [
          {
            "type": "income",
            "description": "salary",
            "date": "04.05.2020",
            "value": "7500",
            "currency": "PLN"
          },
          {
            "type": "outcome",
            "description": "mortgage",
            "date": "06.05.2020",
            "value": "1100",
            "currency": "PLN"
          },
          {
            "type": "income",
            "description": "interests",
            "date": "10.05.2020",
            "value": "1700",
            "currency": "PLN"
          },
          {
            "type": "outcome",
            "description": "transfer",
            "date": "11.05.2020",
            "value": "1200",
            "currency": "PLN"
          }
        ]
      },
      {
        "info": {
          "name": "Natalia",
          "surname": "Nowak",
          "country": "Poland"
        },
        "balance": {
          "total": "6750",
          "currency": "PLN",
          "date": "01.05.2020"
        },
        "transactions": [
          {
            "type": "income",
            "description": "salary",
            "date": "04.05.2020",
            "value": "10500",
            "currency": "PLN"
          },
          {
            "type": "outcome",
            "description": "transfer",
            "date": "10.05.2020",
            "value": "1200",
            "currency": "PLN"
          },
          {
            "type": "outcome",
            "description": "transfer",
            "date": "11.05.2020",
            "value": "1050,50",
            "currency": "PLN"
          }
        ]
      }
    ]
  }
}