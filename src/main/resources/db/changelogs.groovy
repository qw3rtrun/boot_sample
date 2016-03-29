package db

databaseChangeLog {
    changeSet(id: 'my-entity-1.0', author: 'qw3rtrun@gmail.com') {
        createTable(tableName: 'MY_ENTITY') {
            column(name: 'id', type: 'INT', autoIncrement: true)
            column(name: 'name', type: 'VARCHAR(50)')
            column(name: 'version', type: 'INT')
        }
        addPrimaryKey(columnNames: 'id', constraintName: 'pk_ent', tableName: 'MY_ENTITY')
    }

    changeSet(id: 'attr-1.0', author: 'qw3rtrun@gmail.com') {
        createTable(tableName: 'ATTR') {
            column(name: 'id', type: 'INT', autoIncrement: true)
            column(name: 'name', type: 'VARCHAR(50)')
        }
        addPrimaryKey(columnNames: 'id', constraintName: 'pk_attr', tableName: 'ATTR')
    }

    changeSet(id: 'value-1.0', author: 'qw3rtrun@gmail.com') {
        createTable(tableName: 'VALUE') {
            column(name: 'entity_id', type: 'INT')
            column(name: 'attr_id', type: 'INT')
            column(name: 'value', type: 'VARCHAR(50)')
        }
        addPrimaryKey(columnNames: 'entity_id,attr_id', constraintName: 'pk_value', tableName: 'VALUE')
        addForeignKeyConstraint(baseColumnNames: 'entity_id',
                baseTableName: 'VALUE',
                constraintName: 'fk_value_ent',
                onDelete: 'CASCADE',
                onUpdate: 'RESTRICT',
                referencedColumnNames: 'id',
                referencedTableName: 'MY_ENTITY')
        addForeignKeyConstraint(baseColumnNames: 'attr_id',
                baseTableName: 'VALUE',
                constraintName: 'fk_value_attr',
                onDelete: 'CASCADE',
                onUpdate: 'RESTRICT',
                referencedColumnNames: 'id',
                referencedTableName: 'ATTR')
    }
}