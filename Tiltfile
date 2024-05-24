SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='SOURCE-IMAGE-VALUE')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='default')
LIVE_UPDATE_PATH = os.getenv("LIVE_UPDATE_PATH", default='bin/Debug/net6.0')

WAIT_TIMEOUT = os.getenv("WAIT_TIMEOUT", default='10m00s')
TYPE = os.getenv("TYPE", default='web')

k8s_custom_deploy(
    'demoapp',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --update-strategy replace --debug --live-update" +
        " --local-path " + LOCAL_PATH +
        " --build-env BP_DEBUG_ENABLED=true" +
        " --namespace " + NAMESPACE +
        " --wait-timeout " + WAIT_TIMEOUT +
        " --type " + TYPE +
        " --output yaml" +
        " --yes ",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes", 
    deps=['bin'],
    container_selector='workload',
    live_update=[
        sync(LIVE_UPDATE_PATH, '/workspace')
    ]
)

k8s_resource('demoapp', port_forwards=["8080:8080"],
    extra_pod_selectors=[{'carto.run/workload-name': 'demoapp', 'app.kubernetes.io/component':'run'}])
allow_k8s_contexts('mz-wc3-admin@mz-wc3')
