# homework 1
## HTTP Methods and Functions
### CITY
```diff
🟢 GET 
📍 localhost:8080/v1/cities --> Kayıtlı bütün şehirleri getirme

📍 localhost:8080/v1/cities/id --> Belirtilen id'ye sahip şehiri getirme

🟢 POST 
📍 localhost:8080/v1/cities --> Şehir oluşturma
``
{
    "name": "oluşturulacak city ismi",
    "president": "oluşturulacak president ismi"
}
``

🟢 PUT
📍 localhost:8080/v1/cities/id --> Belirtilen id'ye sahip şehiri güncelleme
``
{"president": "güncellenecek president ismi"}
``

🟢 DELETE
📍 localhost:8080/v1/cities/id --> Belirtilen id'ye sahip şehiri silme
