# DataFrame에 대한 JOIN 연산
> SQL의 JOIN 연산을 Pandas 라이브러리를 통해 Python으로 실행 가능
* Pandas의 DataFrame 데이터 타입은 테이블 형식의 데이터 타입으로 SQL 테이블 간의 연산 또한 사용 가능

<hr>
<br>

## DataFrame 

#### 테이블 형식의 데이터 타입

<br>

### [From Dictionary To DataFrame]

```python
import pandas as pd

dict_a = {'key': [1,2,3], 'name': ['Jane', 'John', 'Peter']}
dataframe_a = pd.DataFrame(dict_a, columns = ['key', 'name'])

dict_b = {'key': [2,3,4], 'name': [18, 15, 20]}
dataframe_B = pd.DataFrame(dict_b, columns = ['key', 'name'])

print(dataframe_A)
print(dataframe_B)
```
* ```key``` : key 값이 Col 값
* ```value``` : value 값이 Row 값

<br>

### [From excel/csv/pickle To DataFrame]

```python
import pandas as pd

core_df = pd.read_excel('코어프로그램.xlsx')
employee_df = pd.read_csv("직원.csv")
merged_df = pd.read_pickle("merged_data.pickle")
```
* ```pd.read_excel()``` : Read an Excel file into a pandas DataFrame.
* ```pd.read_csv()``` : Read a comma-separated values (csv) file into DataFrame.
* ```pd.read_pickle()``` : Load pickled pandas object (or any object) from file.

<br>
<hr>
<br>

## JOIN 

#### Inner Join, Outer Join, Left Join, Right Join 연산

<br>

### [pandas.DataFrame.merge]

```python
pd.merge(
    left,
    right,
    how="inner",
    on=None,
    left_on=None,
    right_on=None,
    left_index=False,
    right_index=False,
    sort=True,
    suffixes=("_x", "_y"),
    copy=True,
    indicator=False,
    validate=None,
)
```

* ```left```: A DataFrame or named Series object.
* ```right```: Another DataFrame or named Series object.
* ```on```: Column or index level names to join on. Must be found in both the left and right DataFrame and/or Series objects. If not passed and left_index and right_index are False, the intersection of the columns in the DataFrames and/or Series will be inferred to be the join keys.
* ```left_on```: Columns or index levels from the left DataFrame or Series to use as keys. Can either be column names, index level names, or arrays with length equal to the length of the DataFrame or Series.
* ```right_on```: Columns or index levels from the right DataFrame or Series to use as keys. Can either be column names, index level names, or arrays with length equal to the length of the DataFrame or Series.
* ```how```: One of 'left', 'right', 'outer', 'inner'. Defaults to inner. See below for more detailed description of each method.
