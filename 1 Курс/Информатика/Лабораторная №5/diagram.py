import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_csv("my_day2.csv")
figure, axes = plt.subplots(1, 4, figsize=(16, 4))
data.groupby(['<DATE>']).boxplot(column=["<OPEN>", "<HIGH>", "<LOW>", "<CLOSE>"], ax=axes)

plt.show()