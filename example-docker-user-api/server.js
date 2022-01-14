const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.get('/api/v1/users', (req, res) => {
  res.json([
    {
      name: "Jamila",
      age: 22,
      gender: 'FEMALE'
    },
    {
      name: "Alex",
      age: 18,
      gender: 'MAL'
    }
  ])
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
