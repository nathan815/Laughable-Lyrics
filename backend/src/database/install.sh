#/bin/sh
export $(cat ../../.env | grep DB_ | xargs)

sql_installed_file="";
sql_installed_dir="../installed";

cd schema;

for sql_file in `ls *.sql`; do
    sql_installed_file="$sql_installed_dir/$sql_file"
    if [ ! -e $sql_installed_file ]; then
        if mysql -u$DB_USER -p$DB_PASS $DB_NAME < $sql_file; then
            mkdir $sql_installed_dir;
            touch $sql_installed_file;
        fi
    fi
done

cd ..