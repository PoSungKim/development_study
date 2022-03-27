from datetime import datetime
from textwrap import dedent

import pendulum
from airflow import DAG
from airflow.operators.bash import BashOperator
from airflow.operators.email import EmailOperator
from airflow.operators.python import PythonOperator

default_args = {
    'start_date': pendulum.datetime(year=2022, month=3, day=1),
    # 'start_date': pendulum.now(),
    "depends_on_past" : True,
    'wait_for_downstream': True
}

# DAG 정의
with DAG(
    dag_id='pipeline',
    description="simple pipeline to demonstrate",
    tags=["demonstration"],
    default_args=default_args,
    schedule_interval='@daily',
    catchup=True #Backfill 기능을 어디서부터 진행할 예정인지 False면 가장 최근의 Time Interval로 작업 생성,
) as dag:

    # Task 정의
    t1 = BashOperator(
        task_id='make_test_directory',
        bash_command='mkdir ~/airflow/test',
    )

    t2 = BashOperator(
        task_id='make_txt_file',
        bash_command='touch ~/airflow/test/test.txt',
    )

    t3 = BashOperator(
        task_id='print_date',
        bash_command='date',
    )

    t4 = BashOperator(
        task_id='write_some_words',
        bash_command='echo "put some words" >> ~/airflow/test/test.txt',
    )

    templated_command = dedent(
        """
    {% for i in range(5) %}
        echo "{{ ds }}"
        echo "{{ macros.ds_add(ds, 7)}}"
    {% endfor %}
    """
    )

    t5 = BashOperator(
        task_id='templated',
        bash_command=templated_command,
    )

    # Dependency 정의
    # set_downstream(), set_upstream() 함수 사용 가능
    t1 >> [t2, t3]
    [t2, t3] >> t4
    t4 >> t5

dag.doc_md = __doc__
dag.doc_md = """
# 시연을 위한 DAG
> Task 간의 Depedency 및 로그 조회 등의 기능 테스팅을 위한 자료
"""
