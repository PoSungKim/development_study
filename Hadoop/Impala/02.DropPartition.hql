-- https://118k.tistory.com/780

SHOW PARTITIONS tableName;

ALTER TABLE tableName DROP PARTITION(partitionName='partitionValue');

ALTER TABLE tableName DROP PARTITION(partitionName < 'partitionValue');

ALTER TABLE tableName DROP PARTITION(partitionName BETWEEN 'partitionValue1' AND 'partitionValue2');

ALTER TABLE tableName DROP PARTITION(partitionName < 'partitionValue1'), PARTITION(partitionName > 'partitionValue2');
