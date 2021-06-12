# HOTEL (ADMIN PART)

```bash
호텔 운영에 필요한 ADMIN, CANCEL, CHECK IN/OUT 등의 기능 구현
```
---

## API Structure
### 1. Admin Controller

| API | 의미 | 기본값 |
|---|:---:|---:|
| @GetMapping("/stay") | Admin List  | Admin(List) |
| @DeleteMapping("/stay/{RoomNum}") | CHECK-OUT |  Room |
| @PutMapping("/stay/{id}") | GUEST INFO UPDATE  | Admin |
| @PostMapping("/room") | Room save  | Room |
| @PutMapping("/room/{roomnum}| Room Modify | Room |

* Room save Json
```
{
  "roomnum" : "101",
  "bedtype": "twin",
  "st": "empty"
}
```

---

### 2. Accept Controller

| API | 의미 | 기본값 |
|---|:---:|---:|
| @PostMapping("/accept/{roomnum}") | Check-In  | Admin |
| @GetMapping("/accept/empty") | Empty Room List |  Room(List) |
| @DeleteMapping("/accept/cancel/{id}") | Cancel Book  | String |

* Accept save Json
```
{
  "email" : "baugh248730@gmail.com",
  "name": "kim",
  "phonenum": "010-1234-5677",
  "people": "10"
}
```

* return
```
{
    "id": 1,
    "email": "baugh248730@gmail.com",
    "name": "kim",
    "phonenum": "010-1234-5677",
    "people": "10",
    "room": {
        "roomnum": "101",
        "bedtype": "twin",
         "st": "full"
    }
}
```

* Room의 <b> st(상태) </b> 가 Empty에서 FULL로 변경되고
Check-out 되면 다시 Empty 상태로 변경됨

