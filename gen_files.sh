# header=("ns-go-p-ph-ms01" "ns-go-p-th-ms01")

# for ((i=1; i<4; i+=1)); do
  
# done

# List All Files that are 20240620, 20240621

footer_ls=("test" "test2")

for ((i=20; i<=21; i+=1)); do
  for footer in ${footer_ls[@]}; do
    printf -v filename "202406%02d_$footer.json" $i
    cmd="http://localhost:8081/service/rest/v1/search/assets?name=$filename&repository=trash-upload"
    # Grab Id
    file_id=$(curl --fail -s -u admin:root -X 'GET' $cmd -H 'accept: application/json' | python -c 'import json, sys; print(json.loads(sys.stdin.read())["items"][0]["id"]);')
    
    # Delete File
    cmd="http://localhost:8081/service/rest/v1/assets/$file_id"
    curl --fail -s -u admin:root -X 'DELETE' $cmd -H 'accept: application/json'
  done
done