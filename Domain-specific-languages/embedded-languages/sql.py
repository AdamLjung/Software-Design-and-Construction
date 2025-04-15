#!/usr/bin/env python3

import sqlite3
conn = sqlite3.connect('bible-sqlite.db')
# The table is t_bbe and it has columns b,c,v,t
# Make the requested queries to the database
cursor = conn.cursor()

# Booknumber and amounts of verses
# cursor.execute("SELECT b, COUNT(v) FROM t_bbe GROUP BY b ORDER BY b")

#Booknumbers with verses containing memory
#cursor.execute("SELECT b FROM t_bbe WHERE t LIKE '%memory%' GROUP BY b ORDER BY b")

#The average number of verses each chapter
cursor.execute("SELECT AVG(v_count) FROM (SELECT b, c, COUNT(v) AS v_count FROM t_bbe GROUP BY b,c)")

res = cursor.fetchall()

print(res)
