import requests
import json

#this is a temporary api key (limit is 10 so most probably i exhausted it sorry lol)
req=requests.get("https://api.data.gov.in/resource/6176ee09-3d56-4a3b-8115-21841576b2f6?api-key=579b464db66ec23bdd000001cdd3946e44ce4aad7209ff7b23ac571b&format=json")
response=json.loads(req.text)

print(response)