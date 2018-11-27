package com.example.ruok.service;

import com.example.ruok.constant.Constants;
import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;

import classes.User;
import io.searchbox.client.JestResult;
import io.searchbox.core.Count;
import io.searchbox.core.CountResult;
import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.Update;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;


public class JestService {
    private JestDroidClient client;

    private static JestService instance = null;

    public static synchronized JestService getInstance() {
        if (instance == null)
            instance = new JestService();
        return instance;
    }


    private JestService() {
        this.client = getJestDroidClient();
    }

    /**
     * get JestClient
     *
     * @return
     */
    private JestDroidClient getJestDroidClient() {
        DroidClientConfig.Builder builder = new DroidClientConfig.Builder(Constants.BASE_URL);
        DroidClientConfig config = builder.build();

        JestClientFactory factory = new JestClientFactory();
        factory.setDroidClientConfig(config);
        client = (JestDroidClient) factory.getObject();
        return client;
    }

    /**
     * @param indexName
     * @param typeName
     * @param source
     * @return
     * @throws Exception
     */
    
    public DocumentResult createIndex(String indexName, String typeName, Object source) throws Exception {
        String id = System.currentTimeMillis() + "";
        if (source instanceof User) {
            id = ((User) source).getId();
        }
        Index index = new Index.Builder(source).index(indexName).type(typeName).id(id).build();
        DocumentResult result = client.execute(index);
        return result;
    }


    /**
     * Get
     *
     * @param indexName
     * @param typeName
     * @return
     * @throws Exception
     */

    public String getIndexMapping(String indexName, String typeName) throws Exception {
        GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).addType(typeName).build();
        JestResult jr = client.execute(getMapping);
        return jr.getJsonString();
    }


    /**
     * search file
     *
     * @param indexName
     * @param typeName
     * @param query
     * @return
     * @throws Exception
     */

    public SearchResult search(String indexName, String typeName, String query) throws Exception {

        Search search = new Search.Builder(query)
                .addIndex(indexName)
                .addType(typeName)
                .build();
        return client.execute(search);
    }


    /**
     * Get file
     *
     * @param indexName
     * @param typeName
     * @param id
     * @return
     * @throws Exception
     */
    public JestResult get(String indexName, String typeName, String id) throws Exception {

        Get get = new Get.Builder(indexName, id).type(typeName).build();
        return client.execute(get);
    }

    /**
     * Count file
     *
     * @param indexName
     * @param typeName
     * @param query
     * @return
     * @throws Exception
     */
    public CountResult count(String indexName, String typeName, String query) throws Exception {

        Count count = new Count.Builder()
                .addIndex(indexName)
                .addType(typeName)
                .query(query)
                .build();
        CountResult results = client.execute(count);
        return results;
    }


    /**
     * Delete
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    public boolean delete(String indexName) throws Exception {

        JestResult jr = client.execute(new DeleteIndex.Builder(indexName).build());
        return jr.isSucceeded();
    }

    /**
     * Delete file
     *
     * @param indexName
     * @param typeName
     * @param id
     * @return
     * @throws Exception
     */

    public boolean delete(String indexName, String typeName, String id) throws Exception {

        DocumentResult dr = client.execute(new Delete.Builder(id).index(indexName).type(typeName).build());
        return dr.isSucceeded();
    }

    /**
     * update
     *
     * @param script
     * @param index
     * @param type
     * @param id
     * @return
     */

    public JestResult updateDocument(String script, String index, String type, String id) {
        Update update = new Update.Builder(script).index(index).type(type).id(id).build();
        JestResult result = null;
        try {
            result = client.execute(update);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * close JestClient
     *
     * @throws Exception
     */

    public void closeJestClient() throws Exception {

        if (client != null) {
            client.shutdownClient();
        }
    }


}
