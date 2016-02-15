databaseChangeLog {
    changeSet(id: 'my-entity-1.0', author: 'qw3rtrun@gmail.com') {
        createTable(tableName: 'MY_ENTITY') {
            column(name: 'id', type: 'INT', autoIncrement:true)
            column(name: 'name', type: 'VARCHAR(50)')
            column(name: 'version', type:'INT')
        }
    }
}