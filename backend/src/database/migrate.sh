#/bin/sh
if [[ $PWD != *"src/database" ]]; then
    cd src/database;
fi

export $(cat ../../.env | grep DB_ | xargs)

sql_installed_file="";
sql_installed_dir="../migrated";

result=$?

cd schema;

# Create database
echo "Creating database laughable_lyrics";
sql_installed_file="$sql_installed_dir/1_create_db.sql.txt"
mysql -u$DB_USER -p$DB_PASS < 1_create_db.sql;
result=$?;
if [[ $result == "0" ]] || [[ $result == *"exists"* ]]; then
	mkdir -p $sql_installed_dir;
	touch $sql_installed_file;
	date >> $sql_installed_file;
fi
echo "Complete: 1_create_db.sql";

# Create tables
cd create_tables;

for sql_file in `ls *.sql`; do
    sql_installed_file="$sql_installed_dir/$sql_file.txt"
    if [ ! -e $sql_installed_file ]; then
        echo "Migrating $sql_file";
        mysql -u$DB_USER -p$DB_PASS $DB_NAME < $sql_file;
        result=$?;
        if [[ $result == "0" ]] || [[ $result == *"exists"* ]]; then
            mkdir -p ../$sql_installed_dir;
            touch ../$sql_installed_file;
            date >> ../$sql_installed_file;
        fi
        echo "Complete: $sql_file";
    else
        echo "Skipping $sql_file"
    fi
done

echo "Migration Complete";
exit 0;
